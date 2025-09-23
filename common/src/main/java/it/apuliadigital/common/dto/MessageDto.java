package it.apuliadigital.common.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * Simple DTO for incoming messages via REST.
 */
public class MessageDto {
    @NotBlank
    private String author;
    @NotBlank
    private String content;

    public MessageDto() {}

    public MessageDto(String author, String content) {
        this.author = author;
        this.content = content;
    }

    // getters/setters
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
