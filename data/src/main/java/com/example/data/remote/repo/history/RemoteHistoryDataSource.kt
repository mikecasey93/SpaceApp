package com.example.data.remote.repo.history

import com.example.domain.entity.HistoryObj
import kotlinx.coroutines.flow.Flow

interface RemoteHistoryDataSource {

    fun getHistory(): Flow<List<HistoryObj?>?>

    fun getHistoryItem(id: Int?): Flow<HistoryObj>
}