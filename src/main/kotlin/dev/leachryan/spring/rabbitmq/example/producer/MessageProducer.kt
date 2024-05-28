package dev.leachryan.spring.rabbitmq.example.producer

import dev.leachryan.spring.rabbitmq.example.message.CustomMessage
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class MessageProducer(private val rabbitTemplate: RabbitTemplate) {

    companion object {
        private val logger = LoggerFactory.getLogger(MessageProducer::class.java)
    }

    @Value("\${rabbitmq.exchange}")
    private lateinit var exchange: String

    @Value("\${rabbitmq.routing.key}")
    private lateinit var routingKey: String

    fun sendMessage(message: CustomMessage) {
        logger.info("Sending message...")
        rabbitTemplate.convertAndSend(exchange, routingKey, message)
    }
}