package com.example.data.remote.network.ships


import com.google.gson.annotations.SerializedName

data class PositionModel(
    @SerializedName("latitude")
    val latitude: Double? = 0.0,
    @SerializedName("longitude")
    val longitude: Double? = 0.0
)