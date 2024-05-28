package dev.leachryan.spring.rabbitmq.example

import dev.leachryan.spring.rabbitmq.example.message.CustomMessage
import dev.leachryan.spring.rabbitmq.example.producer.MessageProducer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
	// Get a reference to the application context
	val applicationContext = runApplication<Application>(*args)

	// Get the message producer
	val messageProducer = applicationContext.getBean(MessageProducer::class.java)

	// Send a message
	messageProducer.sendMessage(CustomMessage(
		id = "test-message",
		content = "this is a message"
	))
}
