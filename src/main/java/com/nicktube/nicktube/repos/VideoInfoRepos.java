package com.nicktube.nicktube.repos;

import com.nicktube.nicktube.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VideoInfoRepos extends JpaRepository<Video, UUID> {
}


