package com.example.demo.service;

import com.example.demo.exception.ProblemNotFoundException;
import com.example.demo.model.Problem;
import com.example.demo.repo.ProblemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemService {
    private final ProblemRepo problemRepo;

    @Autowired
    public ProblemService(ProblemRepo problemRepo) {
        this.problemRepo = problemRepo;
    }
    public Problem addProblem(Problem problem){
        return problemRepo.save(problem);
    }
    public List<Problem> findAllProblems(){
        return problemRepo.findAll();
    }
    public Problem updateProblem(Problem problem){
        return problemRepo.save(problem);
    }
    public Problem findProblemById(Long id){
        return problemRepo.findProblemById(id).orElseThrow(()-> new ProblemNotFoundException("The Problem is not found"));
    }
    public void deleteProblem(Long id){
        problemRepo.deleteProblemById(id);
    }
}
