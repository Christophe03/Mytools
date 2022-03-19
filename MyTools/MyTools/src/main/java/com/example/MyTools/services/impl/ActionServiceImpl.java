package com.example.MyTools.services.impl;

import com.example.MyTools.model.Action;
import com.example.MyTools.repository.ActionRepository;
import com.example.MyTools.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActionServiceImpl implements ActionService {
    @Autowired
    ActionRepository actionRepository;

    @Override
    public List<Action> ListeAction() {
        return this.actionRepository.findAll();
    }
}
