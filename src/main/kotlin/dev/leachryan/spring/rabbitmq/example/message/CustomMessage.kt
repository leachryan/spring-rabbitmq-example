package dev.leachryan.spring.rabbitmq.example.message

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class CustomMessage(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("content")
    val content: String
): Serializable
