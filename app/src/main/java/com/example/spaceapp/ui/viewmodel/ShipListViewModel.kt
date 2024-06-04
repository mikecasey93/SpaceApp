package com.example.spaceapp.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.common.nav.routes.ShipInput
import com.example.common.nav.routes.ShipNavRoutes
import com.example.common.state.MviViewModel
import com.example.common.state.UiState
import com.example.domain.usecase.ship.GetShipUseCase
import com.example.spaceapp.converters.ShipListConverter
import com.example.spaceapp.model.ShipListModel
import com.example.spaceapp.ui.uiaction.ship.ShipListAction
import com.example.spaceapp.ui.uiaction.ship.ShipListSingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShipListViewModel @Inject constructor(
    private val useCase: GetShipUseCase,
    private val converter: ShipListConverter
) : MviViewModel<ShipListModel, UiState<ShipListModel>, ShipListAction, ShipListSingleEvent>(){

    override fun initState(): UiState<ShipListModel> = UiState.Loading


    override fun handleAction(action: ShipListAction) {
        when (action) {
            is ShipListAction.Load -> {
                loadShips()
            }
            is ShipListAction.OnShipItemClick -> {
                submitSingleEvent(
                    ShipListSingleEvent.OpenDetailsScreen(
                        ShipNavRoutes.Details.routeForShip(
                            ShipInput(
                                action.model,
                                action.shipName,
                                action.status,
                                action.shipType,
                                action.image,
                                action.weight,
                                action.yearBuilt
                            )
                        )
                    )
                )
            }
        }
    }

    private fun loadShips(){
        viewModelScope.launch {
            useCase.execute(GetShipUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect{
                    submitState(it)
                }
        }
    }
}