package dev.leachryan.spring.rabbitmq.example.config

import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    @Bean
    fun queue(): Queue {
        return Queue("example.queue", false)
    }
}