package com.example.demo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts") // Đặt tên bảng trong MySQL
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL sẽ tự tăng ID (Auto Increment)
    private Long id;

    private String author;

    @Column(columnDefinition = "TEXT") // Cho phép viết nội dung dài
    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Tips: Nhấn Alt + Insert để chọn "Getter and Setter" và "Constructor"
    public Post() {}

    public Post(String author, String content) {
        this.author = author;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
