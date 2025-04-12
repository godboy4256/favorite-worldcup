package com.example.wc_web.controller.worldcup;

import com.example.wc_web.domain.worldcup.WorldCup;
import com.example.wc_web.dto.worldcup.request.CreateWorldCupRequest;
import com.example.wc_web.service.worldcup.WorldCupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorldCupController {

    public WorldCupService worldCupService;

    public WorldCupController(WorldCupService worldCupService){
        this.worldCupService = worldCupService;
    }

    @PostMapping("/world_cup") // 이상형 월드컵 정보 생성
    public void createWorldCup(@RequestBody CreateWorldCupRequest request){
        worldCupService.createWorldCup(request);
    }

    @GetMapping("/world_cup") // 메인 페이지 이상형 월드컵 리스트 목록 조회
    public List<WorldCup> getWorldCupList() {
        return worldCupService.getWorldCup();
    }

    @PutMapping("/world_cup/{worldCupId}") // 메인 페이지 이상형 월드컵 정보 수정
    public void updateWorldCup( @PathVariable Integer worldCupId, @RequestBody CreateWorldCupRequest request){
        worldCupService.updateWorldCup(worldCupId, request);
    }

    @DeleteMapping("/world_cup/{worldCupId}") // 메인 페이지 이상형 월드컵 정보 삭제
    public void deleteWorldCup(
            @PathVariable Integer worldCupId
    ){
        worldCupService.deleteWorldCup(worldCupId);
    }
}
