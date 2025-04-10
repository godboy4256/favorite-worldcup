package com.example.wc_web.service.worldcup;

import com.example.wc_web.domain.worldcup.Candidate;
import com.example.wc_web.domain.worldcup.WorldCup;
import com.example.wc_web.dto.worldcup.request.CreateCandidatesRequest;
import com.example.wc_web.repository.candidates.CandidatesRepository;
import com.example.wc_web.repository.worldcup.WorldCupRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatesService {
    public CandidatesRepository candidatesRepository;
    public WorldCupRepository worldCupRepository;

    public CandidatesService(CandidatesRepository candidatesRepository,WorldCupRepository worldCupRepository){
        this.candidatesRepository = candidatesRepository;
        this.worldCupRepository = worldCupRepository;
    }

    // 해당되는 전체 월드컵 후보를 데이터베이스에 집어넣는 메소드
    public void createCandidates(List<CreateCandidatesRequest> candidateRequestDtoList, Integer worldCupId){

        WorldCup worldCup = worldCupRepository.findById(worldCupId).
                orElseThrow(() -> new IllegalArgumentException("존재하지 않는 월드컵입니다."));;

        List<Candidate> candidates = candidateRequestDtoList.stream()
                .map(dto -> {
                    Candidate candidate = new Candidate();
                    candidate.setName(dto.getName());
                    candidate.setImage(dto.getImage());
                    candidate.setWorldCup(worldCup);
                    return candidate;
                })
                .collect(Collectors.toList());
        candidatesRepository.saveAll(candidates);
    }

    public List<Candidate> getCandidates(Integer worldCupId){
        return candidatesRepository.findByWorldCupId(worldCupId);
    }

    @Transactional
    public void updateCandidate(Integer candidateId, CreateCandidatesRequest request){
        Candidate candidate = candidatesRepository.
                findById(candidateId).
                orElseThrow(() -> new IllegalArgumentException("해당되는 후보가 없습니다."));

        if(request.getName() != null){
            candidate.setName(request.getName());
        }

        if(request.getImage() != null){
            candidate.setImage(request.getImage());
        }
    }

    public void deleteCandidate(Integer candidateId){
        Candidate candidate = candidatesRepository.
                findById(candidateId).
                orElseThrow(() -> new IllegalArgumentException("해당되는 후보가 없습니다."));

        candidatesRepository.delete(candidate);
    }
}

