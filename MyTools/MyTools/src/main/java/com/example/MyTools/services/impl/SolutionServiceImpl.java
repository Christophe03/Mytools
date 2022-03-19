package com.example.MyTools.services.impl;

import com.example.MyTools.model.Solution;
import com.example.MyTools.repository.SolutionRepository;
import com.example.MyTools.services.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SolutionServiceImpl implements SolutionService {
    public SolutionServiceImpl() {
        super();
    }

    @Autowired
    SolutionRepository solutionRepository;
    @Override
    public Solution ajoutSolution(Solution solution) {
        return this.solutionRepository.save(solution);
    }

    @Override
    public List<Solution> afficherListSolution() {
        return this.solutionRepository.findAll();
    }

    @Override
    public void modifierSolution(Solution solution, Integer id) {
        Solution solutionExistant = this.solutionRepository.findById(id).orElseThrow();
        solutionExistant.setEtat(solution.getEtat());
        solutionExistant.setServices(solution.getServices());
        solutionExistant.setReparation(solution.getReparation());
        solutionExistant.setVentes(solution.getVentes());
    }

    @Override
    public Solution afficherById(Integer id) {
        return this.solutionRepository.findById(id).get();
    }
}
