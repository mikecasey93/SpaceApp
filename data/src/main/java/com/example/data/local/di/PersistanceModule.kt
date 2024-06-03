package com.example.data.local.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.db.capsule.CapsuleDao
import com.example.data.local.db.capsule.CapsuleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PersistanceModule {

    @Provides
    fun provideCapsuleDatabase(@ApplicationContext context: Context): CapsuleDatabase =
        Room.databaseBuilder(
            context,
            CapsuleDatabase::class.java, "capsule-database"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideCapsuleDao(database: CapsuleDatabase): CapsuleDao = database.capsuleDao()
}