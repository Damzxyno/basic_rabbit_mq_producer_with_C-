package com.damzxyno.javarabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class JavaRabbitMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaRabbitMqApplication.class, args);
    }

}
