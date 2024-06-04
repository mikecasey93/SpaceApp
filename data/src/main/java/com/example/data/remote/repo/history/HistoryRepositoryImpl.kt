package com.example.data.remote.repo.history

import com.example.domain.entity.HistoryObj
import com.example.domain.repo.HistoryRepository
import kotlinx.coroutines.flow.Flow

class HistoryRepositoryImpl (
    private val remoteSource: RemoteHistoryDataSource
): HistoryRepository {

    override fun getHistory(): Flow<List<HistoryObj?>?> {
        return remoteSource.getHistory()
    }

    override fun getHistoryItem(id: Int?): Flow<HistoryObj> {
        return remoteSource.getHistoryItem(id)
    }
}