package com.example.projetsy43.data.datasources

// CommentDao.kt
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete

@Dao
interface CommentDao {
    @Insert
    suspend fun insert(comment: Comment)

    @Query("SELECT * FROM comments ORDER BY timestamp DESC")
    suspend fun getAllComments(): List<Comment>

    @Query("DELETE FROM comments")
    suspend fun deleteAllComments()
}
