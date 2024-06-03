package com.example.spaceapp.converters

import android.content.Context
import com.example.common.state.CommonResultConverter
import com.example.domain.usecase.GetCapsuleUseCase
import com.example.spaceapp.model.Capsule
import com.example.spaceapp.model.CapsuleListModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class CapsuleListConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetCapsuleUseCase.Response, CapsuleListModel>() {

    override fun convertSuccess(
        data: GetCapsuleUseCase.Response
    ) : CapsuleListModel {
        return CapsuleListModel(
            capsules = data.capsules?.map {
                Capsule(
                    capsuleId = it?.capsuleId,
                    details = it?.details,
                    landings = it?.landings,
                    originalLaunch = it?.originalLaunch,
                    status = it?.status
                )
            } ?: listOf()
        )
    }
}