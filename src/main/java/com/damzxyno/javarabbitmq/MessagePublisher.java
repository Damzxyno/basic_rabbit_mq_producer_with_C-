package com.damzxyno.javarabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/mssg")
@RequiredArgsConstructor
public class MessagePublisher {
    private final RabbitTemplate  rabbitTemplate;

    @GetMapping("{message}")
    public String sendMssg(@PathVariable("message") String message){

        var mssg = CustomMessage.builder()
                .date(new Date())
                .message(message)
                .messageId(UUID.randomUUID().toString())
                .build();

        rabbitTemplate.convertAndSend(
                MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY,
                mssg);

        return "Message sent";
    }
}
