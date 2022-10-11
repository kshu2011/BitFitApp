package com.example.bitfit

class ExerciseFetcher {
    companion object {
        val exerciseList = listOf("Dahlia Cline", "Kevin Miranda", "Kaya Austin", "Laila Calderon", "Marquise Rhodes", "Fletcher Patel", "Luz Barron", "Kamren Dudley", "Jairo Foster", "Lilah Sandoval", "Ansley Blake", "Slade Sawyer", "Jaelyn Holmes", "Phoenix Bright", "Ernesto Gould")
        val exerciseDescription = "Welcome to Kotlin!"

        fun getExercises(): MutableList<Exercise> {
            var emails : MutableList<Exercise> = ArrayList()
            for (i in 0..9) {
                val email = Exercise(exerciseList[i], exerciseDescription)
                emails.add(email)
            }
            return emails
        }
    }
}
