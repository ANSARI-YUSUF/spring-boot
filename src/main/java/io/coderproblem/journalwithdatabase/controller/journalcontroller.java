package io.coderproblem.journalwithdatabase.controller;

import io.coderproblem.journalwithdatabase.services.journalservice;


import io.coderproblem.journalwithdatabase.entity.journalentry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/journal")
public class journalcontroller {

    @Autowired
    journalservice journalservice;;

//    private Map<Long, journalentry> je =new HashMap();

    @GetMapping("/see")
    public List<journalentry> getentry(){
        return journalservice.seewithGET();
//        localhost:8080/journal for GET
    }
    @PostMapping("/save")
    public boolean createentry(@RequestBody journalentry myentry){
//        localhost:8080/journal for post

//        journalservice.savejournal(myentry);


        try {
            myentry.setDate(LocalDateTime.now());
            journalservice.savejournal(myentry);
            return true;
        } catch (Exception e) {
            System.out.println("eoor"+e);
            return  false;
        }



//        je.put(me.getId(),me);

    }
    @GetMapping("/see/{myid}")
    public journalentry getentrybyid(@PathVariable ObjectId myid){

        return  journalservice.seewithid(myid).orElse(null);

    }

    @DeleteMapping("/delete/{myid}")
    public String deleteentrybyid(@PathVariable ObjectId myid){
        journalservice.deletewithid(myid);

        return  "deleted";

    }
    @PutMapping("/update/{id}")
    public journalentry update(@PathVariable ObjectId id, @RequestBody journalentry newmyje){


        try {
//            myje.setDate(LocalDateTime.now());

            journalentry oldje =journalservice.seewithid(id).orElse(null);
            if(oldje !=null){

                oldje.setTitle(newmyje.getTitle()!=null && !newmyje.getTitle().equals("") ? newmyje.getTitle() : oldje.getTitle());

                oldje.setContent(newmyje.getContent()!=null && !newmyje.getContent().equals("") ? newmyje.getContent() : oldje.getContent());
            }
            journalservice.savejournal(oldje);
            return oldje;
        } catch (Exception e) {
            System.out.println("eoor"+e);
            return  newmyje;
        }

//        return null;
    }
}





