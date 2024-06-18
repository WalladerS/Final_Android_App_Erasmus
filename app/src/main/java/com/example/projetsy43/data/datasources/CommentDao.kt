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

    @Query("SELECT * FROM comments WHERE schoolId = :schoolId")
    suspend fun getAllCommentsForSchool(schoolId: Long): List<Comment>

    @Query("UPDATE comments SET likes = likes + 1 WHERE id = :commentId")
    suspend fun likeComment(commentId: Int)

    @Query("UPDATE comments SET likes = likes - 1 WHERE id = :commentId")
    suspend fun unlikeComment(commentId: Int)

    @Query("DELETE FROM comments")
    suspend fun deleteAllComments()
}

