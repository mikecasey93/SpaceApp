package com.example.data.local.db.capsule

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson

@Database(
    entities = [
        CapsuleEntity::class
    ],
    version = 2,
    exportSchema = false
)
@TypeConverters(CapsuleConverters::class)
abstract class CapsuleDatabase : RoomDatabase() {

    abstract fun capsuleDao(): CapsuleDao
}

class CapsuleConverters {

    @TypeConverter
    fun listToJsonString(value: List<Int?>?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String?) =
        Gson().fromJson(value, Array<Int?>::class.java).toList()
}
