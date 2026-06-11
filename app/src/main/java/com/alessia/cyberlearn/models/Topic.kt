package com.alessia.cyberlearn.models

data class Topic(
    val id: Int,
    val title: String,
    val subtitle: String,
    val iconResId: Int,
    val lessonText: String,
    val questions: List<Question>
)