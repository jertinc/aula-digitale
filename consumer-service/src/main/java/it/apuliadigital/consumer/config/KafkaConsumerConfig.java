package it.apuliadigital.consumer.config;

import org.springframework.context.annotation.Configuration;

/**
 * Declares the topic (if broker supports topic creation via AdminClient).
 * Keeps consumer config minimal because Spring Boot auto-configures ConsumerFactory
 * using properties in application.properties.
 */
@Configuration
public class KafkaConsumerConfig {
}
