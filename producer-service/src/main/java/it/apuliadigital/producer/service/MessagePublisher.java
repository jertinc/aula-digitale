package it.apuliadigital.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.apuliadigital.common.dto.MessageDto;
import it.apuliadigital.common.model.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * Service responsible for converting domain DTO to JSON and publishing to Kafka.
 * Keeping JSON serialization explicit lets students swap serializers easily.
 */
@Service
public class MessagePublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper;
    private final String topic;

    public MessagePublisher(KafkaTemplate<String, String> kafkaTemplate,
                            ObjectMapper mapper,
                            org.springframework.core.env.Environment env) {
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
        this.topic = env.getProperty("app.topic.messages");
    }

    public void publish(MessageDto dto) {
        Message message = new Message(dto.getAuthor(), dto.getContent(), Instant.now());
        try {
            String payload = mapper.writeValueAsString(message);
            kafkaTemplate.send(topic, payload);
        } catch (JsonProcessingException e) {
            // in real apps use structured logging; here we surface the problem
            throw new RuntimeException("Failed to serialize message", e);
        }
    }
}
