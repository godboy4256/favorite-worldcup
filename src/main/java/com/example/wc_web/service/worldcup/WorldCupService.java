package com.example.wc_web.service.worldcup;

import com.example.wc_web.domain.worldcup.WorldCup;
import com.example.wc_web.repository.worldcup.WorldCupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorldCupService {
    public WorldCupRepository worldCupRepository;
    public WorldCupService(WorldCupRepository worldCupRepository){
        this.worldCupRepository = worldCupRepository;
    }
    public List<WorldCup> getWorldCup(){
        return worldCupRepository.findAll();
    }
    public void createWorldCup(String title, String description, String thumbnail){
        worldCupRepository.save(new WorldCup(title, description, thumbnail));
    }
}
