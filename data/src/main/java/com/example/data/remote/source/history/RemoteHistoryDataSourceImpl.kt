package com.example.data.remote.source.history

import android.location.Location.convert
import com.example.data.remote.endpoints.SpaceAppEndPoints
import com.example.data.remote.network.history.HistoryItemModel
import com.example.data.remote.repo.capsule.RemoteCapsuleDataSource
import com.example.data.remote.repo.history.RemoteHistoryDataSource
import com.example.domain.entity.HistoryObj
import com.example.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteHistoryDataSourceImpl @Inject constructor(
    private val service: SpaceAppEndPoints
) : RemoteHistoryDataSource {
    override fun getHistory(): Flow<List<HistoryObj?>?> = flow {
        val history = service.getHistory()
        emit(history)
    }.map { historyList ->
        historyList.map { history -> convert(history) }
    }.catch {
        throw UseCaseException.AppException(it)
    }

    override fun getHistoryItem(id: Int?): Flow<HistoryObj> = flow {
        emit(service.getHistoryItem(id))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.AppException(it)
    }

    private fun convert(model: HistoryItemModel): HistoryObj {
        return HistoryObj(
            details = model.details,
            eventDateUnix = model.eventDateUnix,
            flightNumber = model.flightNumber,
            id = model.id,
            title = model.title
        )
    }
}