package com.example.projetsy43.data.repository

// CommentRepository.kt
import com.example.projetsy43.data.datasources.Comment
import com.example.projetsy43.data.datasources.CommentDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CommentRepository(private val commentDao: CommentDao) {
    suspend fun insert(comment: Comment) {
        commentDao.insert(comment)
    }

    suspend fun getAllCommentsForSchool(schoolId: Long): List<Comment> {
        return commentDao.getAllCommentsForSchool(schoolId)
    }

    suspend fun likeComment(commentId: Int) {
        withContext(Dispatchers.IO) {
            commentDao.likeComment(commentId)
        }
    }

    suspend fun unlikeComment(commentId: Int) {
        withContext(Dispatchers.IO) {
            commentDao.unlikeComment(commentId)
        }
    }

    suspend fun deleteAllComments() {
        withContext(Dispatchers.IO) {
            commentDao.deleteAllComments()
        }
    }
}
