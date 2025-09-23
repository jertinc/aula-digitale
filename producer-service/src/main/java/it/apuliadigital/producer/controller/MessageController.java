package it.apuliadigital.producer.controller;

import it.apuliadigital.common.dto.MessageDto;
import it.apuliadigital.producer.service.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple REST controller exposing one POST endpoint to publish messages.
 * Designed for clarity for students: validation, response handling and separation from service.
 */
@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final MessagePublisher publisher;

    public MessageController(MessagePublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping
    public void publishMessage(@RequestBody MessageDto message) {
        publisher.publish(message);
    }

}
