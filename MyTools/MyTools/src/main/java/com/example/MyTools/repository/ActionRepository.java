package com.example.MyTools.repository;

import com.example.MyTools.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ActionRepository extends JpaRepository<Action, Integer> {

    List<Action> findActionByDateCreation(LocalDate localDate);
}
