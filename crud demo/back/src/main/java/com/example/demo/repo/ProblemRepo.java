package com.example.demo.repo;

import com.example.demo.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProblemRepo extends JpaRepository<Problem,Long> {
    void deleteProblemById(Long id);

    Optional<Problem> findProblemById(Long id);
}
