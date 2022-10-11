package com.example.bitfit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_table")
data class ExerciseEntity(
    @ColumnInfo(name = "exerciseName") val exerciseName: String?,
    @ColumnInfo(name = "exerciseInfo") val exerciseInfo: String?,
    @PrimaryKey(autoGenerate = true) val id: Long = 0,

    )