package it.apuliadigital.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Lightweight config: declare topic with Admin auto creation in mind.
 * Keeps configuration minimal so unit tests can override properties.
 */
@Configuration
public class KafkaProducerConfig {
    @Value("app.topic.messages")
    private String messagesTopic;

    @Bean
    public NewTopic messagesTopic() {
        return new NewTopic(messagesTopic, 1, (short) 1);
    }
}
