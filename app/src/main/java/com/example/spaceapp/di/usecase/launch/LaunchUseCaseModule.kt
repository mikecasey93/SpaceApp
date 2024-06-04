package com.example.spaceapp.di.usecase.launch

import com.example.domain.repo.LaunchRepository
import com.example.domain.usecase.UseCase
import com.example.domain.usecase.launch.GetLaunchByIdUseCase
import com.example.domain.usecase.launch.GetLaunchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LaunchUseCaseModule {

    @Provides
    fun provideGetLaunchesUseCase(
        configuration: UseCase.Configuration,
        repository: LaunchRepository
    ): GetLaunchUseCase = GetLaunchUseCase(
        configuration,
        repository
    )

    @Provides
    fun provideGetLaunchByNumberUseCase(
        configuration: UseCase.Configuration,
        repository: LaunchRepository
    ) : GetLaunchByIdUseCase = GetLaunchByIdUseCase(
        configuration,
        repository
    )
}