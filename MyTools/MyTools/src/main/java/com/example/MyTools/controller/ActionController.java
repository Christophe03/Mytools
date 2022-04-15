package com.example.MyTools.controller;

import com.example.MyTools.model.Action;
import com.example.MyTools.services.ActionService;
import com.example.MyTools.services.impl.ActionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/mytools/action")
@CrossOrigin("*")
public class ActionController {
    @Autowired
    ActionServiceImpl actionServiceImpl;

    @PostMapping("/ajout")
    Action ajout(@RequestBody Action action){
        return actionServiceImpl.ajoutAction(action);
    }

    @GetMapping("/lister")
    public List<Action> ListeAction(){
        return this.actionServiceImpl.ListeAction();
    }

    @GetMapping("/{id}")
    Action actionId(@PathVariable Integer id){
        return actionServiceImpl.afficherId(id);
    }

    @GetMapping("{date}")
    List<Action> parJour(@PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate localdate){
        return actionServiceImpl.getActionByDate(localdate);
    }

}
