package com.example.spaceapp.converters

import android.content.Context
import com.example.common.state.CommonResultConverter
import com.example.domain.usecase.history.GetHistoryUseCase
import com.example.spaceapp.model.History
import com.example.spaceapp.model.HistoryListModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class HistoryListConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetHistoryUseCase.Response, HistoryListModel>() {

    override fun convertSuccess(
        data: GetHistoryUseCase.Response
    ): HistoryListModel {
        return HistoryListModel(
            items = data.history?.map {
                History(
                    details = it?.details,
                    eventDateUtc = it?.eventDateUtc,
                    flightNumber = it?.flightNumber,
                    id = it?.id,
                    title = it?.title,
                )
            } ?: listOf()
        )

    }


}