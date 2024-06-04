package com.example.spaceapp.converters

import android.content.Context
import com.example.common.state.CommonResultConverter
import com.example.domain.entity.MissionObj
import com.example.domain.usecase.mission.GetMissionUseCase
import com.example.spaceapp.model.Mission
import com.example.spaceapp.model.MissionListModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MissionListConverter @Inject constructor(
    @ApplicationContext private val context: Context
): CommonResultConverter<GetMissionUseCase.Response, MissionListModel>() {
    override fun convertSuccess(data: GetMissionUseCase.Response): MissionListModel {
        return MissionListModel(
            items = data.missions!!.map {
                Mission(
                    description = it?.description,
                    missionId = it?.missionId,
                    missionName = it?.missionName,
                )
            }
        )
    }


}