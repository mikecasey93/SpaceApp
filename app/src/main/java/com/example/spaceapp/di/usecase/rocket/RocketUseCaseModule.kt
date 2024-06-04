package com.example.spaceapp.di.usecase.rocket

import com.example.domain.repo.RocketRepository
import com.example.domain.usecase.UseCase
import com.example.domain.usecase.rocket.GetRocketByIdUseCase
import com.example.domain.usecase.rocket.GetRocketUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RocketUseCaseModule {

    @Provides
    fun provideGetRocketsUseCase(
        configuration: UseCase.Configuration,
        repository: RocketRepository
    ) : GetRocketUseCase = GetRocketUseCase(
        configuration,
        repository
    )

    @Provides
    fun provideGetRocketByIdUseCase(
        configuration: UseCase.Configuration,
        repository: RocketRepository
    ) : GetRocketByIdUseCase = GetRocketByIdUseCase(
        configuration,
        repository
    )
}