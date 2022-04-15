package com.example.MyTools.services.impl;

import com.example.MyTools.model.Action;
import com.example.MyTools.model.Atelier;
import com.example.MyTools.model.Client;
import com.example.MyTools.model.Professionnel;
import com.example.MyTools.repository.ActionRepository;
import com.example.MyTools.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ActionServiceImpl implements ActionService {
    @Autowired
    ActionRepository actionRepository;

    @Override
    public List<Action> ListeAction() {
        return this.actionRepository.findAll();
    }

    @Override
    public Action ajoutAction(Action action) {
        return actionRepository.save(action);
    }

    @Override
    public List<Action> getActionByDate(LocalDate localDate) {
        return actionRepository.findActionByDateCreation(localDate);
    }

    @Override
    public Action afficherId(Integer id) {
        return actionRepository.findById(id).get();
    }

    public void addActionAtelier(Atelier atelier, String action){
        Action action1 = new Action();
        action1.setAtelier(atelier);
        action1.setAction(action);
        actionRepository.save(action1);
    }

    public void addActionClient(Client client, String action){
        Action action1 = new Action();
        action1.setClient(client);
        action1.setAction(action);
        actionRepository.save(action1);
    }

    public void addActionProfessionnel(Professionnel professionnel, String action){
        Action action1 = new Action();
        action1.setProfessionnel(professionnel);
        action1.setAction(action);
        actionRepository.save(action1);
    }
}
