package com.example.MyTools.services;

import com.example.MyTools.model.Solution;

import java.util.List;

public interface SolutionService {
    Solution ajoutSolution(Solution solution);
    List<Solution> afficherListSolution();
    void modifierSolution(Solution solution, Integer id);
    Solution afficherById(Integer id);
}
