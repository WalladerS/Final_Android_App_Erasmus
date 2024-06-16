package com.example.projetsy43.data.datasources

// AppDatabase.kt
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Comment::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun commentDao(): CommentDao
}
