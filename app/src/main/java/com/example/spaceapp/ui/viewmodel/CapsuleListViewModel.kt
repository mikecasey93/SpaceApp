package com.example.spaceapp.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.common.nav.routes.CapsuleInput
import com.example.common.nav.routes.CapsuleNavRoute
import com.example.common.state.MviViewModel
import com.example.common.state.UiState
import com.example.domain.usecase.capsule.GetCapsuleUseCase
import com.example.spaceapp.converters.CapsuleListConverter
import com.example.spaceapp.model.CapsuleListModel
import com.example.spaceapp.ui.uiaction.capsule.CapsuleListAction
import com.example.spaceapp.ui.uiaction.capsule.CapsuleListSingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CapsuleListViewModel @Inject constructor(
    private val useCase: GetCapsuleUseCase,
    private val converter: CapsuleListConverter
): MviViewModel<CapsuleListModel, UiState<CapsuleListModel>, CapsuleListAction, CapsuleListSingleEvent>() {
    override fun initState(): UiState<CapsuleListModel> = UiState.Loading

    override fun handleAction(action: CapsuleListAction) {
        when (action) {
            is CapsuleListAction.Load -> {
                loadCapsules()
            }
            is CapsuleListAction.CapsuleItemClick -> {
                submitSingleEvent(
                    CapsuleListSingleEvent.GoToDetailsScreen(
                        CapsuleNavRoute.Details.routeForCapsule(
                            CapsuleInput(
                                action.capsuleId,
                                action.details,
                                action.landings,
                                action.originalLaunch,
                                action.status
                            )
                        )
                    )
                )
            }
        }
    }

    private fun loadCapsules() {
        viewModelScope.launch {
            useCase.execute(GetCapsuleUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect {
                    submitState(it)
                }
        }
    }
}