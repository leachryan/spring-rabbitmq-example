package dev.leachryan.spring.rabbitmq.example.consumer

import dev.leachryan.spring.rabbitmq.example.message.CustomMessage
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class MessageConsumer {

    companion object {
        private val logger = LoggerFactory.getLogger(MessageConsumer::class.java)
    }

    @RabbitListener(queues = ["\${rabbitmq.queue}"])
    fun receiveMessage(message: CustomMessage) {
        logger.info("Received message: $message")
    }
}