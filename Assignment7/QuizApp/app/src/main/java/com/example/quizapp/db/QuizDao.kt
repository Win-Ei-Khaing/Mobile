package com.example.quizapp.db

import androidx.room.*

@Dao
interface QuizDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuiz(quiz: Quiz)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuizzes(vararg quiz: Quiz)

    @Query("SELECT * FROM quiz ORDER BY id")
    suspend fun getAllQuizzes(): List<Quiz>

    @Update
    suspend fun updateQuiz(quiz: Quiz)

    @Delete
    suspend fun deleteQuiz(quiz: Quiz)

    @Query("DELETE FROM quiz WHERE 1=1")
    suspend fun deleteAllQuiz()
}
