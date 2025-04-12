package com.example.wc_web.repository.worldcup;

import com.example.wc_web.domain.worldcup.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CandidatesRepository extends JpaRepository<Candidate, Integer> {
    List<Candidate> findByWorldCupId(Integer worldCupId);
    Optional<Candidate> findById(Integer candidateId);
}
