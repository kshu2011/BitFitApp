package com.example.bitfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    //lateinit var exerciseList: MutableList<DisplayExercise>
    private val exerciseList = mutableListOf<DisplayExercise>()
    //private var exerciseList: MutableList<DisplayExercise>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.addButton).setOnClickListener{
            val exerciseName = findViewById<EditText>(R.id.exerciseNameEdit).text.toString()
            val exerciseInfo = findViewById<EditText>(R.id.exerciseDescriptionEdit).text.toString()

            //save the event to Database
            lifecycleScope.launch(IO) {
                (application as MyApplication).db.exerciseDao().insert(
                    ExerciseEntity(exerciseName, exerciseInfo)
                )
            }
        }

        //get the recyclerView here
        val exerciseRv = findViewById<RecyclerView>(R.id.exerciseRv)
        //get the list of exercise
      //  exerciseList = ExerciseFetcher.getExercises()
        //now create adapter and pass the list of exercise
        val adapter = ExerciseAdapter(this,exerciseList)
        //attach adapter to the recyclerview
        exerciseRv.adapter = adapter


        lifecycleScope.launch {
            (application as MyApplication).db.exerciseDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    DisplayExercise(
                        entity.exerciseName,
                        entity.exerciseInfo,
                    )
                }.also { mappedList ->
                    exerciseList.clear()
                    exerciseList.addAll(mappedList)
                    adapter.notifyDataSetChanged()
                }
            }
        }





        //set layout manager to position the items
        exerciseRv.layoutManager = LinearLayoutManager(this)
    }
}