package com.example.data.local.db.capsule

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CapsuleDao {

    @Query("SELECT * FROM capsule")
    fun getCapsules(): Flow<List<CapsuleEntity>>

    @Query("SELECT * FROM capsule WHERE capsule_serial = :capsuleId")
    fun getCapsule(capsuleId: String?): Flow<CapsuleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCapsule(capsules: List<CapsuleEntity>)

}