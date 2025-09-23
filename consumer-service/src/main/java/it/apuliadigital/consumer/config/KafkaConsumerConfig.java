package it.apuliadigital.consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Declares the topic (if broker supports topic creation via AdminClient).
 * Keeps consumer config minimal because Spring Boot auto-configures ConsumerFactory
 * using properties in application.properties.
 */
@Configuration
public class KafkaConsumerConfig {
    @Value("app.topic.messages")
    private String messagesTopic;

    @Bean
    public NewTopic messagesTopic() {
        return new NewTopic(messagesTopic, 1, (short) 1);
    }
}
