package com.example.projetsy43.data.datasources

// AppDatabase.kt
import androidx.room.Database
import androidx.room.RoomDatabase




@Database(entities = [Comment::class], version = 3) // version 3 car on a modifié la database à 2 reprises
abstract class AppDatabase : RoomDatabase() {
    abstract fun commentDao(): CommentDao
}

