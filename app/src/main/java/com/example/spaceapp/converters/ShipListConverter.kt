package com.example.spaceapp.converters

import android.content.Context
import com.example.common.state.CommonResultConverter
import com.example.domain.usecase.ship.GetShipUseCase
import com.example.spaceapp.model.ShipItem
import com.example.spaceapp.model.ShipListModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ShipListConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetShipUseCase.Response, ShipListModel>(){

    override fun convertSuccess(data: GetShipUseCase.Response): ShipListModel {
        return ShipListModel(
            items = data.ship.map {
                ShipItem(
                    active = it.active,
                    image = it.image,
                    shipType = it.shipId,
                    shipName = it.shipName,
                    shipId = it.shipId,
                    status = it.status,
                    url = it.url,
                    weightLbs = it.weightLbs,
                    yearBuilt = it.yearBuilt
                )
            }
        )
    }
}