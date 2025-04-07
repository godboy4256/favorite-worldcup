package com.example.wc_web.repository.candidates;

import com.example.wc_web.domain.worldcup.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatesRepository extends JpaRepository<Candidates, Integer> {
}
