package com.example.wc_web.controller.worldcup;

import com.example.wc_web.domain.worldcup.Candidate;
import com.example.wc_web.dto.worldcup.request.CreateCandidatesRequest;
import com.example.wc_web.service.worldcup.CandidatesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CandidatesController {
    final private CandidatesService candidatesService;

    public CandidatesController(CandidatesService candidatesService){
        this.candidatesService = candidatesService;
    }

    // 이상형 월드컵 후보자 등록하기
    @PostMapping("/candidates/{worldCupId}")
    public void createCandidates(
            @PathVariable Integer worldCupId,
            @RequestBody List<CreateCandidatesRequest> requests
    ){
        candidatesService.createCandidates(requests,worldCupId);
    }

    // 이상형 월드컵 후보자 불러오기
    @GetMapping("/candidates/{worldCupId}")
    public List<Candidate> getCandidates(
            @PathVariable Integer worldCupId
    ){
       return candidatesService.getCandidates(worldCupId);
    }

    // 이상형 월드컵 후보자 정보 수정
    @PutMapping("/candidates/{candidateId}")
    public void updateCandidate(
            @PathVariable Integer candidateId,
            @RequestBody CreateCandidatesRequest request
    ){
        candidatesService.updateCandidate(candidateId,request);
    }

    // 이상형 월드컵 후보자 정보 삭제
    @DeleteMapping("/candidates/{candidateId}")
    public void deleteCandidate(
            @PathVariable Integer candidateId
    ){
        candidatesService.deleteCandidate(candidateId);
    }
}
