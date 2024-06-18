package com.example.projetsy43.data.datasources

// AppDatabase.kt
import androidx.room.Database
import androidx.room.RoomDatabase




@Database(entities = [Comment::class], version = 3) // Incremented version number
abstract class AppDatabase : RoomDatabase() {
    abstract fun commentDao(): CommentDao
}

