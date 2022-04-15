package com.example.MyTools.services;

import com.example.MyTools.model.Action;

import java.time.LocalDate;
import java.util.List;

public interface ActionService {
    List<Action> ListeAction();
    Action ajoutAction(Action action);
    List<Action> getActionByDate(LocalDate localDate);
    Action afficherId(Integer id);
}
