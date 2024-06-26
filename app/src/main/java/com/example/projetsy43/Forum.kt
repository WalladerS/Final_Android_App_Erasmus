package com.example.projetsy43

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.room.Room
import kotlinx.coroutines.launch
import com.example.projetsy43.data.repository.CommentRepository
import com.example.projetsy43.data.datasources.AppDatabase
import com.example.projetsy43.data.datasources.Comment
import com.example.projetsy43.data.datasources.ForumMessage
import com.example.projetsy43.data.datasources.School

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Forum(school: School) {
    val context = LocalContext.current
    val database = remember { initializeDatabase(context) }
    val repository = remember { CommentRepository(database.commentDao()) }
    val coroutineScope = rememberCoroutineScope()
    val keyboardController = LocalSoftwareKeyboardController.current

    var listForum by remember { mutableStateOf(listOf<ForumMessage>()) }
    var newComment by remember { mutableStateOf(TextFieldValue("")) }
    val likedComments = remember { mutableStateOf(mutableSetOf<Int>()) }

    // Load comments from the database
    LaunchedEffect(school) {
        val comments = repository.getAllCommentsForSchool(school.id).map { comment ->
            ForumMessage(
                id = comment.id,
                fimg = R.drawable.user,
                content = comment.message,
                likes = comment.likes,
                comments = 0
            )
        }
        listForum = comments
    }

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEBF5FB))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Reviews from other students:",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))

            listForum.forEach { message ->
                ForumMessageItem(message = message, onLike = {
                    coroutineScope.launch {
                        if (likedComments.value.contains(message.id)) {
                            repository.unlikeComment(message.id)
                            likedComments.value.remove(message.id)
                        } else {
                            repository.likeComment(message.id)
                            likedComments.value.add(message.id)
                        }
                        val updatedComments = repository.getAllCommentsForSchool(school.id).map { comment ->
                            ForumMessage(
                                id = comment.id,
                                fimg = R.drawable.user,
                                content = comment.message,
                                likes = comment.likes,
                                comments = 0
                            )
                        }
                        listForum = updatedComments
                    }
                }, isLiked = likedComments.value.contains(message.id))
                Spacer(modifier = Modifier.height(10.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))


            OutlinedTextField(
                value = newComment,
                onValueChange = { newComment = it },
                label = { Text("Enter a comment") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Text
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        if (newComment.text.isNotBlank()) {
                            coroutineScope.launch {
                                val comment = Comment(
                                    message = newComment.text,
                                    timestamp = System.currentTimeMillis(),
                                    schoolId = school.id
                                )
                                repository.insert(comment)
                                val updatedComments = repository.getAllCommentsForSchool(school.id).map { comment ->
                                    ForumMessage(
                                        id = comment.id,
                                        fimg = R.drawable.user,
                                        content = comment.message,
                                        likes = comment.likes,
                                        comments = 0
                                    )
                                }
                                listForum = updatedComments
                                newComment = TextFieldValue("")
                            }
                            keyboardController?.hide()
                        }
                    }
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                if (newComment.text.isNotBlank()) {
                    coroutineScope.launch {
                        val comment = Comment(
                            message = newComment.text,
                            timestamp = System.currentTimeMillis(),
                            schoolId = school.id
                        )
                        repository.insert(comment)
                        val updatedComments = repository.getAllCommentsForSchool(school.id).map { comment ->
                            ForumMessage(
                                id = comment.id,
                                fimg = R.drawable.user,
                                content = comment.message,
                                likes = comment.likes,
                                comments = 0
                            )
                        }
                        listForum = updatedComments
                        newComment = TextFieldValue("")
                        keyboardController?.hide()
                    }
                }
            }) {
                Text("Submit")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                coroutineScope.launch {
                    repository.deleteAllComments()
                    listForum = emptyList()
                }
            }) {
                Text("Clear Comments")
            }
        }
    }
}

fun initializeDatabase(context: Context): AppDatabase {
    return Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java, "app-database"
    ).fallbackToDestructiveMigration()
        .build()
}

@Composable
fun ForumMessageItem(message: ForumMessage, onLike: () -> Unit, isLiked: Boolean) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = message.fimg),
            contentDescription = "User Image",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = message.content,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onLike) {
                    Image(
                        painter = painterResource(id = if (isLiked) R.drawable.liked else R.drawable.like),
                        contentDescription = "Like Icon",
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = message.likes.toString(),
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }
    }
}
