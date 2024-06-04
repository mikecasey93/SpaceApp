package com.example.spaceapp.converters

import android.content.Context
import com.example.common.state.CommonResultConverter
import com.example.domain.entity.RocketObj
import com.example.domain.usecase.rocket.GetRocketUseCase
import com.example.spaceapp.model.Rocket
import com.example.spaceapp.model.RocketListModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class RocketListConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetRocketUseCase.Response, RocketListModel>() {
    override fun convertSuccess(data: GetRocketUseCase.Response): RocketListModel {
        return RocketListModel(
            items = data.rockets!!.map {
                Rocket(
                    description = it?.description,
                    id = it?.id,
                    rocketName = it?.rocketName,
                    company = it?.company,
                    costPerLaunch = it?.costPerLaunch,
                    country = it?.country
                )
            }
        )
    }


}