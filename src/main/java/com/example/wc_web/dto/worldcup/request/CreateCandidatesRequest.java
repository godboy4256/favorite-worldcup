package com.example.wc_web.dto.worldcup.request;

import lombok.Getter;

@Getter
public class CreateCandidatesRequest {
    private String name;
    private String image;

    public CreateCandidatesRequest(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
