

package com.example.projetsy43.data.datasources
import com.example.projetsy43.data.datasources.ForumMessage
import com.example.projetsy43.R

object ForumData {
    val latestMessages = listOf(
    ForumMessage("Welcome to Android Studio!", R.drawable.androidstudio, likes = 10, comments = 5),
    ForumMessage("Kotlin Course!", R.drawable.kotlin, likes = 15, comments = 8)
    )
    fun getForumData() = latestMessages
    fun getFirstForum(): ForumMessage {
        return latestMessages.first()
    }
}