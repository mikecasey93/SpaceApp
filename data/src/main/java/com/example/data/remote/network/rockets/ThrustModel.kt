package com.example.data.remote.network.rockets


import com.google.gson.annotations.SerializedName

data class ThrustModel(
    @SerializedName("kN")
    val kN: Int? = 0,
    @SerializedName("lbf")
    val lbf: Int? = 0
)