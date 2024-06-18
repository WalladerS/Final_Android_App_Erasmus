package com.example.projetsy43.data.datasources

object ReportData {


    private val reports = listOf(
        Report(
            id = SchoolData.getSchoolByUid(1),
            number_student_registered = 3,
            max_student_registered = 10,
            note_school = 4,
            note_life = 4,
            note_difficulty = 4),
        Report(id = SchoolData.getSchoolByUid(2),
            number_student_registered = 9,
            max_student_registered = 10,
            note_school = 3,
            note_life = 12,
            note_difficulty = 4),
        Report(id = SchoolData.getSchoolByUid(3),
            number_student_registered = 0,
            max_student_registered = 10,
            note_school = 4,
            note_life = 12,
            note_difficulty = 3),
        Report(id = SchoolData.getSchoolByUid(4),
            number_student_registered = 4,
            max_student_registered = 10,
            note_school = 4,
            note_life = 10,
            note_difficulty = 12),
        Report(id = SchoolData.getSchoolByUid(5),
            number_student_registered = 3,
            max_student_registered = 10,
            note_school = 4,
            note_life = 10,
            note_difficulty = 2),
        Report(id = SchoolData.getSchoolByUid(6),
            number_student_registered = 2,
            max_student_registered = 10,
            note_school = 4,
            note_life = 11,
            note_difficulty = 10),
        Report(id = SchoolData.getSchoolByUid(7),
            number_student_registered = 3,
            max_student_registered = 10,
            note_school = 4,
            note_life = 10,
            note_difficulty = 2),
        Report(id = SchoolData.getSchoolByUid(8),
            number_student_registered = 3,
            max_student_registered = 10,
            note_school = 4,
            note_life = 10,
            note_difficulty = 2),
        Report(id = SchoolData.getSchoolByUid(9),
            number_student_registered = 3,
            max_student_registered = 10,
            note_school = 4,
            note_life = 10,
            note_difficulty = 2),
    )

    fun getDefaultReportData() = reports.first()
    fun getReportByUid(uid: Long): Report {
        return reports.first { it.id.id == uid }
    }

}

