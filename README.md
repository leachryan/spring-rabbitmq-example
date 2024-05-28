# spring-rabbitmq-example

## Intro

Example project using RabbitMQ to produce and consume messages

## Setup

### Application Properties

Set up the following application properties before running the application:

```properties
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=rabbituser
spring.rabbitmq.password=password
rabbitmq.queue=example.queue
rabbitmq.exchange=example.exchange
rabbitmq.routing.key=example.routing.key
```