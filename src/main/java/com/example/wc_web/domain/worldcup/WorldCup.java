package com.example.wc_web.domain.worldcup;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class WorldCup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer id = null;

    private  String title = null;
    private  String description = null;
    private  String thumbnail = null;

    public WorldCup(String title, String description, String thumbnail) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public WorldCup(){};
}
