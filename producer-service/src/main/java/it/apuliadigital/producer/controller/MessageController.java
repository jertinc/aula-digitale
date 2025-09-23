package it.apuliadigital.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple REST controller exposing one POST endpoint to publish messages.
 * Designed for clarity for students: validation, response handling and separation from service.
 */
@RestController
@RequestMapping("/api/messages")
public class MessageController {
}
