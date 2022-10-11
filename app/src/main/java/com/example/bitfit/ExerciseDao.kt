package com.example.bitfit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {
    @Query("SELECT * FROM exercise_table")
    fun getAll(): Flow<List<ExerciseEntity>>

    @Insert
    fun insertAll(exercises: List<ExerciseEntity>)

    @Insert
    fun insert(exercise: ExerciseEntity)

//    @Query("DELETE FROM exercise_table")
//    fun deleteAll()
}