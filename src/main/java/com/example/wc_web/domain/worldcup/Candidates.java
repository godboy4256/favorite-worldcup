package com.example.wc_web.domain.worldcup;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Candidates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = null;

    private String name = null;
    private String image = null;
    private Integer worldcup_id = null;

    public Candidates(Integer id, String name, String image, Integer worldcup_id) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.worldcup_id = worldcup_id;
    }

    public Candidates() {}
}
