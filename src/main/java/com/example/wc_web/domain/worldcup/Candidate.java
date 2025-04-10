package com.example.wc_web.domain.worldcup;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = null;

    private String name = null;
    private String image = null;

    public Candidate(Integer id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    @ManyToOne
    @JoinColumn(name = "world_cup_id")
    private WorldCup worldCup;

    public Candidate() {}
}
