package com.example.spaceapp.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.common.nav.routes.LaunchInput
import com.example.common.nav.routes.LaunchNavRoutes
import com.example.common.state.MviViewModel
import com.example.common.state.UiState
import com.example.domain.usecase.launch.GetLaunchUseCase
import com.example.spaceapp.converters.LaunchListConverter
import com.example.spaceapp.model.LaunchListModel
import com.example.spaceapp.ui.uiaction.launch.LaunchListAction
import com.example.spaceapp.ui.uiaction.launch.LaunchListSingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchListViewModel @Inject constructor(
    private val useCase: GetLaunchUseCase,
    private val converter: LaunchListConverter
) : MviViewModel<LaunchListModel, UiState<LaunchListModel>, LaunchListAction, LaunchListSingleEvent>() {

    override fun initState(): UiState<LaunchListModel> = UiState.Loading


    override fun handleAction(action: LaunchListAction) {
        when (action) {
            is LaunchListAction.Load -> {
                loadLaunches()
            }
            is LaunchListAction.OnLaunchItemClick -> {
                submitSingleEvent(
                    LaunchListSingleEvent.OpenDetailsScreen(
                        LaunchNavRoutes.Details.routeForLaunch(
                            LaunchInput(
                                action.details,
                                action.success,
                                action.missionName,
                                action.launchYear
                            )
                        )
                    )
                )
            }
        }
    }

    private fun loadLaunches() {
        viewModelScope.launch {
            useCase.execute(GetLaunchUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect {
                    submitState(it)
                }

        }
    }


}