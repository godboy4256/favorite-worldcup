package com.example.wc_web.controller.worldcup;

import com.example.wc_web.dto.worldcup.request.CreateCandidatesRequest;
import com.example.wc_web.service.worldcup.CandidatesService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CandidatesController {
    private CandidatesService candidatesService;

    public CandidatesController(CandidatesService candidatesService){
        this.candidatesService = candidatesService;
    }

    @PostMapping("/candidates/{worldcupId}")
    public void createCandidates(
            @PathVariable Integer worldcupId,
            @RequestBody List<CreateCandidatesRequest> requests
    ){
        candidatesService.createCandidates(requests,worldcupId);
    }
}
