package com.example.data.remote.network.rockets


import com.google.gson.annotations.SerializedName

data class PayloadsModel(
    @SerializedName("composite_fairing")
    val compositeFairing: CompositeFairingModel? = CompositeFairingModel(),
    @SerializedName("option_1")
    val option1: String? = "",
    @SerializedName("option_2")
    val option2: String? = ""
)