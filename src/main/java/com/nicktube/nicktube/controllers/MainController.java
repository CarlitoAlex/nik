package com.nicktube.nicktube.controllers;

import com.nicktube.nicktube.service.VideoService;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@RestController
public class MainController {
    @Value("${id1}")
    private String id;
    @Value("${id2}")
    private String id2;
    @Value("${id3}")
    private String id3;
    @Value("${id4}")
    private String id4;
    @Value("${id5}")
    private String id5;
    @Value("${id6}")
    private String id6;
    @Value("${id7}")
    private String id7;
    @Value("${id8}")
    private String id8;
    @Value("${id9}")
    private String id9;
    @Value("${id10}")
    private String id10;
    @Value("${googleApiKey}")
    private String apiKey;

    @Autowired
    private VideoService videoService;

    @Scheduled(cron = "0 */30 * ? * *")
    public void parseStatistic(){
        for (int i = 0; i < listId().size(); i++) {
            if (!listId().isEmpty() && !listId().get(i).equals("")) {
                Response response = given()
                        .param("id", listId().get(i))
                        .param("key", apiKey)
                        .param("part", "statistics")
                        .get("https://www.googleapis.com/youtube/v3/videos");
                String count = response.jsonPath().getString("items[0].statistics.viewCount");
                String likes = response.jsonPath().getString("items[0].statistics.likeCount");
                String dislikes = response.jsonPath().getString("items[0].statistics.dislikeCount");
                String comments = response.jsonPath().getString("items[0].statistics.commentCount");
                videoService.saveVideoInfo(listId().get(i), count, likes, dislikes, comments);
            }
        }
    }

    public List<String> listId() {
        List<String> list = new ArrayList<>();
        list.add(id);
        list.add(id2);
        list.add(id3);
        list.add(id4);
        list.add(id5);
        list.add(id6);
        list.add(id7);
        list.add(id8);
        list.add(id9);
        list.add(id10);
        return list;
    }
}

