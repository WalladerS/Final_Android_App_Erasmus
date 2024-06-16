package com.example.projetsy43.data.datasources

data class Report(
    val id: School,
    val number_student_registered: Long,
    val note_school: Long,
    val note_life: Long,
    val note_difficulty: Long,
    val max_student_registered: Int,
    val total_note_school: Int = 20,
    val total_note_life : Int =  5,
    val total_difficulty: Int =  5
)
