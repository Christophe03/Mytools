package com.example.MyTools.controller;

import com.example.MyTools.model.Solution;
import com.example.MyTools.services.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mytools/solution")
@CrossOrigin("*")
public class SolutionController {
    @Autowired
    SolutionService solutionService;
    @PostMapping("/ajouter")
    public String ajoutSolution (@RequestBody Solution solution){
        this.solutionService.ajoutSolution(solution);
        return "Accessoire Ajouter avec success";
    }
    @GetMapping("/lister")
    public List<Solution> afficherListSolution() {
        return  this.solutionService.afficherListSolution();
    }

    @GetMapping("/{id}")
    public Solution afficherById(@PathVariable("id") Integer id){
        return  this.solutionService.afficherById(id);
    }
    @PutMapping("/modifier/{id}")
    public String modifierSolution (@RequestBody Solution solution, @PathVariable("id") Integer id){
        this.solutionService.modifierSolution(solution, id);
        return "Mise à Jours effectuer avec success";
    }
}
