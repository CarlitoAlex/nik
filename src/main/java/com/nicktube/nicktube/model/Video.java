package com.nicktube.nicktube.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "video_info")

public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String idVideo;
    private LocalDateTime createdAt;
    private String likes;
    private String disLikes;
    private String view;
    private String comments;

    public Video() {
    }

    public Video(UUID uuid, String idVideo, LocalDateTime createdAt, String likes, String disLikes, String view, String comments) {
        this.uuid = uuid;
        this.idVideo = idVideo;
        this.createdAt = createdAt;
        this.likes = likes;
        this.disLikes = disLikes;
        this.view = view;
        this.comments = comments;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDisLikes() {
        return disLikes;
    }

    public void setDisLikes(String disLikes) {
        this.disLikes = disLikes;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
