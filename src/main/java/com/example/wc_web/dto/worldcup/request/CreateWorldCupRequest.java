package com.example.wc_web.dto.worldcup.request;

import lombok.Getter;

@Getter
public class CreateWorldCupRequest {
    private String title;
    private String description;
    private String thumbnail;

    public CreateWorldCupRequest(String title, String description, String thumbnail){
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
    }
}
