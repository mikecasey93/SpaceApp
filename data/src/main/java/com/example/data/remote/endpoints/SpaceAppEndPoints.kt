package com.example.data.remote.endpoints

import com.example.data.remote.network.capsule.CapsuleItemModel
import com.example.data.remote.network.history.HistoryItemModel
import com.example.data.remote.network.launch.LaunchItemModel
import com.example.data.remote.network.mission.MissionItemModel
import com.example.data.remote.network.rocket.RocketItemModel
import com.example.data.remote.network.ship.ShipItemModel
import retrofit2.http.GET

interface SpaceAppEndPoints {

    @GET("capsules")
    suspend fun getCapsules(): List<CapsuleItemModel>

    @GET("capsules/{capsule_serial}")
    suspend fun getCapsule(serial: String?): CapsuleItemModel

    @GET("history")
    suspend fun getHistory(): List<HistoryItemModel>

    @GET("history/{id}")
    suspend fun getHistoryItem(id: Int?): HistoryItemModel

    @GET("missions")
    suspend fun getMissions(): List<MissionItemModel>

    @GET("missions/{mission_id}")
    suspend fun getMission(id: String?): MissionItemModel

    @GET("rockets")
    suspend fun getRockets(): List<RocketItemModel>

    @GET("rockets/{id}")
    suspend fun getRocket(id: Int?): RocketItemModel

    @GET("launches")
    suspend fun getLaunches(): List<LaunchItemModel>

    @GET("launches/{flight_number}")
    suspend fun getLaunch(id: Int?): LaunchItemModel

    @GET("ships")
    suspend fun getShips(): List<ShipItemModel>

    @GET("ships/{ship_id}")
    suspend fun getShip(id: String?): ShipItemModel


}