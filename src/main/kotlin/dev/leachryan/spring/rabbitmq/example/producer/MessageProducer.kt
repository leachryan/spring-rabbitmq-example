package dev.leachryan.spring.rabbitmq.example.producer

import dev.leachryan.spring.rabbitmq.example.message.CustomMessage
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class MessageProducer(private val rabbitTemplate: RabbitTemplate) {

    @Value("\${rabbitmq.queue}")
    private lateinit var queueName: String

    fun sendMessage(message: CustomMessage) {
        rabbitTemplate.convertAndSend(message)
    }
}