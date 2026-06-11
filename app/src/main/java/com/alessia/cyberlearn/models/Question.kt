package com.alessia.cyberlearn.models

data class Question(
    val text: String,
    val options: List<String>,
    val correctIndex: Int
)