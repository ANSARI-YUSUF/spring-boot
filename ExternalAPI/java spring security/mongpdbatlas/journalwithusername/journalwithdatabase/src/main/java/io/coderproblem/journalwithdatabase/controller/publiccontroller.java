package io.coderproblem.journalwithdatabase.controller;

import io.coderproblem.journalwithdatabase.api.reponse.WheatherResponse;
import io.coderproblem.journalwithdatabase.entity.user;
import io.coderproblem.journalwithdatabase.services.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.coderproblem.journalwithdatabase.services.userservice;
import io.coderproblem.journalwithdatabase.services.wheatehersevice;

@RestController
@RequestMapping("/public")
public class publiccontroller {
    @Autowired
    private userservice userservice;
    @Autowired
    public wheatehersevice ws;


    @PostMapping("/create")
    public  void createuser( @RequestBody user user){
        userservice.savejournal(user);

    }
    @GetMapping("/wheather")
    public ResponseEntity<?> getwheather(){
        WheatherResponse wr = ws.getexternelapi("SURAT");
        String greeting="";
        if(ws != null){
            greeting="wheather of surat"+wr.getCurrent()+wr.getLocation();


        }
//        return ResponseEntity<>("hi"+);

        return new ResponseEntity<>("hiii"+greeting,HttpStatus.OK);
    }

}
