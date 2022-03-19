package com.example.MyTools.controller;

import com.example.MyTools.model.Action;
import com.example.MyTools.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mytools/action")
@CrossOrigin("*")
public class ActionController {
    @Autowired
    ActionService actionService;

    @GetMapping("/lister")
    public List<Action> ListeAction(){
        return this.actionService.ListeAction();
    }
}
