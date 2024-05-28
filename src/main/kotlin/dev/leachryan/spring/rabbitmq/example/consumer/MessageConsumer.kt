package dev.leachryan.spring.rabbitmq.example.consumer

import dev.leachryan.spring.rabbitmq.example.message.CustomMessage
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class MessageConsumer {

    @RabbitListener(queues = ["example.queue"])
    fun receiveMessage(message: CustomMessage) {

    }
}