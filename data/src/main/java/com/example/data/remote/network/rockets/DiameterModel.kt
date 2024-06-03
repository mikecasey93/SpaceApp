package com.example.data.remote.network.rockets


import com.google.gson.annotations.SerializedName

data class DiameterModel(
    @SerializedName("feet")
    val feet: Double? = 0.0,
    @SerializedName("meters")
    val meters: Double? = 0.0
)