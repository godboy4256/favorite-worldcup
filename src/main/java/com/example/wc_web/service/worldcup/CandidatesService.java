package com.example.wc_web.service.worldcup;

import com.example.wc_web.domain.worldcup.Candidates;
import com.example.wc_web.dto.worldcup.request.CreateCandidatesRequest;
import com.example.wc_web.repository.candidates.CandidatesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatesService {
    public CandidatesRepository candidatesRepository;

    public CandidatesService(CandidatesRepository candidatesRepository){
        this.candidatesRepository = candidatesRepository;
    }

    // 해당되는 전체 월드컵 후보를 데이터베이스에 집어넣는 메소드
    public void createCandidates(List<CreateCandidatesRequest> candidateRequestDtoList, Integer worldcupId){
        List<Candidates> candidates = candidateRequestDtoList.stream()
                .map(dto -> {
                    Candidates candidate = new Candidates();
                    candidate.setName(dto.getName());
                    candidate.setImage(dto.getImage());
                    candidate.setWorldcup_id(worldcupId);
                    return candidate;
                })
                .collect(Collectors.toList());
        candidatesRepository.saveAll(candidates);
    }
}

