package com.example.wc_web.domain.worldcup;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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


    @OneToMany(mappedBy = "worldCup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Candidate> candidates;

    public WorldCup(){};
}
