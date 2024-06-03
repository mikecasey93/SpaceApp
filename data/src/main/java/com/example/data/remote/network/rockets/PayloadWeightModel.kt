package com.example.data.remote.network.rockets


import com.google.gson.annotations.SerializedName

data class PayloadWeightModel(
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("kg")
    val kg: Int? = 0,
    @SerializedName("lb")
    val lb: Int? = 0,
    @SerializedName("name")
    val name: String? = ""
)