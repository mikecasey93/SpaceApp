package com.example.domain.entity

data class HistoryObj(
    val details: String? = "",
    val eventDateUnix: Int? = 0,
    val eventDateUtc: String? = "",
    val flightNumber: Int? = 0,
    val id: Int? = 0,
    val title: String? = ""
)
