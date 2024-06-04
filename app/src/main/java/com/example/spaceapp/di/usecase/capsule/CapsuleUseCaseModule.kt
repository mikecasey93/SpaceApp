package com.example.spaceapp.di.usecase.capsule

import com.example.domain.repo.CapsuleRepository
import com.example.domain.usecase.UseCase
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
        configuration: UseCase.Configuration,
        repository: CapsuleRepository
    ): GetCapsuleUseCase = GetCapsuleUseCase(
        configuration,
        repository
    )

    @Provides
    fun GetCapsuleByIdUseCase(
        configuration: UseCase.Configuration,
        repository: CapsuleRepository
    ): GetCapsuleByIdUseCase = GetCapsuleByIdUseCase(
        configuration,
        repository
    )
}