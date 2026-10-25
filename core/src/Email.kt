package org.example.demo

import kotlinx.serialization.Serializable

@Serializable
data class Email(
    val id: Int,
    val from: String,
    val subject: String,
    val date: String,
    val body: String,
)
