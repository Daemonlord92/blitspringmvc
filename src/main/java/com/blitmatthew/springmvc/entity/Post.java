package com.blitmatthew.springmvc.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class Post {
    private Integer id;
    @NotNull
    @Size(min = 5, max = 75, message = "Title must be minimum 5 characters to 75 maximum!")
    private String title;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Must be letters only!")
    @Size(min = 10, max = 256, message = "Body has to be between 10 and 256 characters to post!")
    private String body;
    private PostStatus status;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public Post() {
    }

    public Post(Integer id, String title, String body, PostStatus status, LocalDateTime createdOn, LocalDateTime updatedOn) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.status = status;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
}
