package it.apuliadigital.consumer.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.apuliadigital.consumer.model.StoredMessage;
import it.apuliadigital.consumer.repository.StoredMessageRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * Simple Kafka listener that parses incoming JSON and persists it.
 */
@Service
public class MessageListener {

    private final StoredMessageRepository repository;
    private final ObjectMapper mapper;

    public MessageListener(StoredMessageRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @KafkaListener(topics = "${app.topic.messages}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String payload) {
        try {
            JsonNode node = mapper.readTree(payload);
            String author = node.path("author").asText("unknown");
            String content =  node.path("content").asText("unknown");
            String createdAt =  node.path("createdAt").asText("unknown");
            Instant created = Instant.parse(createdAt);
            StoredMessage storedMessage = new StoredMessage(author, content, created);
            repository.save(storedMessage);
        } catch (Exception ignored) {}

        System.out.println("Received message: " + payload);
    }
}
