package com.example.bitfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

//        val exerciseName = findViewById<EditText>(R.id.exerciseNameTextView)
//        val exerciseInfo = findViewById<EditText>(R.id.exerciseDescriptionTextView)

        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
           // Log.d("test",exerciseName)
            val exerciseName = findViewById<EditText>(R.id.exerciseNameTextView).text.toString()
            val exerciseInfo = findViewById<EditText>(R.id.exerciseDescriptionTextView).text.toString()


            //save the event to Database
            lifecycleScope.launch(IO) {
                (application as MyApplication).db.exerciseDao().insert(
                    ExerciseEntity(exerciseName, exerciseInfo)
                )
            }
        }
    }
}