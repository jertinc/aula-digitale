package it.apuliadigital.consumer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Entity used to persist messages consumed from Kafka.
 * Kept 'flat' for educational clarity.
 */
@Entity
@Table(name = "stored_messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoredMessage {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    @Column(length = 2000)
    private String content;
    private Instant createdAt;

    public StoredMessage(String author, String content, Instant createdAt) {
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
    }
}
