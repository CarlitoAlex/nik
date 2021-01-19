package com.nicktube.nicktube.service;

import com.nicktube.nicktube.model.Video;
import com.nicktube.nicktube.repos.VideoInfoRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class VideoService {

    @Autowired
    private VideoInfoRepos videoInfoRepos;


    public void saveVideoInfo(String idVideo,String view,String likes,String dislikes,String comments){
        Video video = new Video();
        video.setUuid(UUID.randomUUID());
        video.setIdVideo(idVideo);
        video.setCreatedAt(LocalDateTime.now());
        video.setView(view);
        video.setLikes(likes);
        video.setDisLikes(dislikes);
        video.setComments(comments);
        videoInfoRepos.save(video);
    }


}
