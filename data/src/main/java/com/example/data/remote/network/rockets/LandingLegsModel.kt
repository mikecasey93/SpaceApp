package com.example.data.remote.network.rockets


import com.google.gson.annotations.SerializedName

data class LandingLegsModel(
    @SerializedName("material")
    val material: String? = "",
    @SerializedName("number")
    val number: Int? = 0
)