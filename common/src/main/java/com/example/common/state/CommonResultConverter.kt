package com.example.common.state

import com.example.domain.entity.Result


abstract class CommonResultConverter<T : Any, R : Any> {

    fun convert (result: Result<T>): UiState<R> {
        return when (result) {
            is Result.Error -> {
                UiState.Error(result.exception.localizedMessage.orEmpty())
            }
            is Result.Success -> {
                UiState.Success(convertSuccess(result.data))
            }
        }
    }

    abstract fun convertSuccess(data: T): R
}