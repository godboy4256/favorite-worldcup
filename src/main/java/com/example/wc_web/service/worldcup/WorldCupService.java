package com.example.wc_web.service.worldcup;

import com.example.wc_web.domain.worldcup.WorldCup;
import com.example.wc_web.dto.worldcup.request.CreateWorldCupRequest;
import com.example.wc_web.repository.worldcup.WorldCupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

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

    public void createWorldCup(CreateWorldCupRequest request){
        worldCupRepository.save(new WorldCup(request.getTitle(), request.getDescription(), request.getThumbnail()));
    }

    @Transactional // 변경을 감지하면 변경해줄 필요가 없도록 하기
    public void updateWorldCup(Integer id, CreateWorldCupRequest request){
        WorldCup worldCup = worldCupRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 월드컵입니다."));;
        if(request.getTitle() != null){
            worldCup.setTitle(request.getTitle());
        }
        if(request.getDescription() != null){
            worldCup.setDescription(request.getDescription());
        }
        if(request.getThumbnail() != null){
            worldCup.setDescription(request.getThumbnail());
        }
    }

    public void deleteWorldCup(Integer id){
        WorldCup worldCup = worldCupRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 월드컵입니다."));;
        worldCupRepository.delete(worldCup);
    }
}
