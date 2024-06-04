package com.example.spaceapp.di.usecase.capsule

import com.example.domain.usecase.capsule.GetCapsuleByIdUseCase
import com.example.domain.usecase.capsule.GetCapsuleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CapsuleUseCaseModule {

    @Provides
    fun provideGetCapsulesUseCase(
        configuration: com.example.domain.usecase.UseCase.Configuration,
        repository: com.example.domain.repo.CapsuleRepository
    ): GetCapsuleUseCase = GetCapsuleUseCase(
        configuration,
        repository
    )

    @Provides
    fun GetCapsuleByIdUseCase(
        configuration: com.example.domain.usecase.UseCase.Configuration,
        repository: com.example.domain.repo.CapsuleRepository
    ): GetCapsuleByIdUseCase = GetCapsuleByIdUseCase(
        configuration,
        repository
    )
}