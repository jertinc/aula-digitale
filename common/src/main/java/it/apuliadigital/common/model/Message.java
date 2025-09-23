package it.apuliadigital.common.model;

import java.time.Instant;

/**
 * Shared domain model used across services.
 * Kept minimal to be easily serializable as plain JSON string if needed.
 */
public class Message {
    private String author;
    private String content;
    private Instant createdAt;

    public Message() {}

    public Message(String author, String content, Instant createdAt) {
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
    }

    // getters & setters
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
