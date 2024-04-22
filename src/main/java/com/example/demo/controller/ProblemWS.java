package com.example.demo.controller;

import com.example.demo.model.Problem;
import com.example.demo.service.ProblemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/problem")
public class ProblemWS {
    private final ProblemService problemService;

    public ProblemWS(ProblemService problemService) {
        this.problemService = problemService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Problem>> getAllProblems(){
        List<Problem> problemList= problemService.findAllProblems();
        return new ResponseEntity<>(problemList, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Problem> getProblemById(@PathVariable("id") Long id){
        Problem problem= problemService.findProblemById(id);
        return new ResponseEntity<>(problem, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Problem> addProblem(@RequestBody Problem problem){
        Problem newProblem= problemService.addProblem(problem);
        return new ResponseEntity<>(newProblem, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Problem> updateProblem(@RequestBody Problem problem){
        Problem newProblem= problemService.updateProblem(problem);
        return new ResponseEntity<>(newProblem, HttpStatus.OK);
    }
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProblem(@PathVariable("id") Long id){
        problemService.deleteProblem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
