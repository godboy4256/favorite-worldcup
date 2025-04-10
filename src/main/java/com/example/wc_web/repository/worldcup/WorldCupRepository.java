package com.example.wc_web.repository.worldcup;

import com.example.wc_web.domain.worldcup.WorldCup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorldCupRepository extends JpaRepository<WorldCup,Integer> {
    Optional<WorldCup> findById(Integer id);
}
