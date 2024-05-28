package dev.leachryan.spring.rabbitmq.example.config

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class RabbitMQConfig {

    @Value("\${rabbitmq.queue}")
    private lateinit var queue: String

    @Value("\${rabbitmq.exchange}")
    private lateinit var exchange: String

    @Value("\${rabbitmq.routing.key}")
    private lateinit var routingKey: String

    @Bean
    fun queue(): Queue {
        return Queue(queue, false)
    }

    @Bean
    fun exchange(): TopicExchange {
        return TopicExchange(exchange)
    }

    @Bean
    fun queueBinding(): Binding {
        return BindingBuilder.bind(queue()).to(exchange()).with(routingKey)
    }

    @Bean
    fun rabbitTemplate(connectionFactory: ConnectionFactory): RabbitTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = producerJackson2MessageConverter()
        return rabbitTemplate
    }

    @Bean
    fun producerJackson2MessageConverter(): Jackson2JsonMessageConverter {
        return Jackson2JsonMessageConverter()
    }
}