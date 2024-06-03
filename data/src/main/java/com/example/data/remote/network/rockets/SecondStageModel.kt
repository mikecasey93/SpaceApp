package com.example.data.remote.network.rockets


import com.google.gson.annotations.SerializedName

data class SecondStageModel(
    @SerializedName("burn_time_sec")
    val burnTimeSec: Int? = 0,
    @SerializedName("engines")
    val engines: Int? = 0,
    @SerializedName("fuel_amount_tons")
    val fuelAmountTons: Double? = 0.0,
    @SerializedName("payloads")
    val payloads: PayloadsModel? = PayloadsModel(),
    @SerializedName("thrust")
    val thrust: ThrustModel? = ThrustModel()
)