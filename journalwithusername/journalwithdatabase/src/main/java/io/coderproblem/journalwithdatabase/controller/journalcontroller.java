package io.coderproblem.journalwithdatabase.controller;

import io.coderproblem.journalwithdatabase.services.journalservice;


import io.coderproblem.journalwithdatabase.entity.journalentry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;


@RestController
@RequestMapping("/journal")
public class journalcontroller {

    @Autowired
    journalservice journalservice;;

//    private Map<Long, journalentry> je =new HashMap();

    @GetMapping("/see")
    public ResponseEntity<?> getentry(){

        List<journalentry> all=journalservice.seewithGET();
        if(all!=null && !all.isEmpty()){
            return  new ResponseEntity<>(all,HttpStatus.OK);

        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        localhost:8080/journal for GET
    }
    @PostMapping("/save")
    public ResponseEntity<journalentry> createentry(@RequestBody journalentry myentry){
//        localhost:8080/journal for post

//        journalservice.savejournal(myentry);


        try {
            myentry.setDate(LocalDateTime.now());
            journalservice.savejournal(myentry);
            return new ResponseEntity<>(myentry, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("eoor"+e);
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }



//        je.put(me.getId(),me);

    }
    @GetMapping("/see/{myid}")
    public ResponseEntity<journalentry> getentrybyid(@PathVariable ObjectId myid){

       Optional<journalentry> journalentry= journalservice.seewithid(myid);
//        journalservice.seewithid(myid);
        if(journalentry.isPresent()){
            return new ResponseEntity<>(journalentry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{myid}")
    public ResponseEntity<?> deleteentrybyid(@PathVariable ObjectId myid){
        journalservice.deletewithid(myid);

        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable ObjectId id, @RequestBody journalentry newmyje){


        try {
//            myje.setDate(LocalDateTime.now());

            journalentry oldje =journalservice.seewithid(id).orElse(null);
            if(oldje !=null){

                oldje.setTitle(newmyje.getTitle()!=null && !newmyje.getTitle().equals("") ? newmyje.getTitle() : oldje.getTitle());

                oldje.setContent(newmyje.getContent()!=null && !newmyje.getContent().equals("") ? newmyje.getContent() : oldje.getContent());
            journalservice.savejournal(oldje);
            return new ResponseEntity<>(oldje,HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println("eoor"+e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

//        return null;
    }
}





