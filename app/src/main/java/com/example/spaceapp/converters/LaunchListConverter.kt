package com.example.spaceapp.converters

import android.content.Context
import com.example.common.state.CommonResultConverter
import com.example.domain.entity.LaunchObj
import com.example.domain.usecase.launch.GetLaunchUseCase
import com.example.spaceapp.model.Launch
import com.example.spaceapp.model.LaunchListModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LaunchListConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetLaunchUseCase.Response, LaunchListModel>(){

    override fun convertSuccess(
        data: GetLaunchUseCase.Response
    ): LaunchListModel {
        return LaunchListModel(
            items = data.launches!!.map {
                Launch(
                    details = it?.details,
                    flightNumber = it?.flightNumber,
                    launchSuccess = it?.launchSuccess,
                    launchYear = it?.launchYear,
                    missionName = it?.missionName,

                    )
            }
        )
    }

}