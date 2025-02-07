package io.coderproblem.journalwithdatabase.controller;

import io.coderproblem.journalwithdatabase.entity.user;
import io.coderproblem.journalwithdatabase.services.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.coderproblem.journalwithdatabase.services.userservice;

@RestController
@RequestMapping("/public")
public class publiccontroller {
    @Autowired
    private userservice userservice;


    @PostMapping("/create")
    public  void createuser( @RequestBody user user){
        userservice.savejournal(user);

    }

}
