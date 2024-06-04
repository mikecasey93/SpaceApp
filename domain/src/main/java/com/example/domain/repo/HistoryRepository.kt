package com.example.domain.repo

import com.example.domain.entity.HistoryObj
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {

    fun getHistory(): Flow<List<HistoryObj?>?>

    fun getHistoryItem(id: Int?): Flow<HistoryObj>
}