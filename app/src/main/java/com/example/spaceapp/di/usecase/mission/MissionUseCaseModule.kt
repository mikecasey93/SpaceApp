package com.example.spaceapp.di.usecase.mission

import com.example.domain.repo.MissionRepository
import com.example.domain.usecase.UseCase
import com.example.domain.usecase.mission.GetMissionByIdUseCase
import com.example.domain.usecase.mission.GetMissionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MissionUseCaseModule {

    @Provides
    fun provideGetMissionUseCase(
        configuration: UseCase.Configuration,
        repository: MissionRepository
    ): GetMissionUseCase = GetMissionUseCase(
        configuration,
        repository
    )

    @Provides
    fun provideGetMissionByIdUseCase(
        configuration: UseCase.Configuration,
        repository: MissionRepository
    ): GetMissionByIdUseCase = GetMissionByIdUseCase(
        configuration,
        repository
    )

}