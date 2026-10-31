package org.example.demo.mail

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data class Mail(val id: Int) : NavKey
