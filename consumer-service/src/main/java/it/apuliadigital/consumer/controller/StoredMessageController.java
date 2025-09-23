package it.apuliadigital.consumer.controller;

import it.apuliadigital.consumer.model.StoredMessage;
import it.apuliadigital.consumer.repository.StoredMessageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A tiny read API so students can check what's been persisted.
 */
@RestController
@RequestMapping("/api/stored")
public class StoredMessageController {
    private final StoredMessageRepository repository;

    public StoredMessageController(StoredMessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<StoredMessage> all() {
        return repository.findAll();
    }
}
