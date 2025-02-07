package io.coderproblem.journalwithdatabase.controller;

import io.coderproblem.journalwithdatabase.entity.user;
import io.coderproblem.journalwithdatabase.services.journalservice;

import io.coderproblem.journalwithdatabase.services.userservice;
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

    @Autowired
    userservice userservice;;

//    private Map<Long, journalentry> je =new HashMap();

    @GetMapping("/see/user/{usernameforjournal}")
    public ResponseEntity<?> getentrybyusername(@PathVariable String  usernameforjournal){
       user byuser= userservice.findByusername(usernameforjournal);



        List<journalentry> all=byuser.getJournalentries();
        if(all!=null && !all.isEmpty()){
            return  new ResponseEntity<>(all,HttpStatus.OK);

        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        localhost:8080/journal for GET
    }
    @PostMapping("/save/user/{usernameforjournal}")
    public ResponseEntity<journalentry> createentrybyuser
            (@RequestBody journalentry myentry,
             @ PathVariable String usernameforjournal){
//        localhost:8080/journal for post

//        journalservice.savejournal(myentry);
//        user byuser=userservice.findByusername(usernamebyj);


        try {
            myentry.setDate(LocalDateTime.now());
            journalservice.savejournal(myentry,usernameforjournal);
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

    @DeleteMapping("/delete/{username}/{myid}")
    public ResponseEntity<?> deleteentrybyid(@PathVariable ObjectId myid,@PathVariable String username){
        journalservice.deletewithid(myid,username   );

        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

//
    @PutMapping("/update/{username}/{id}")
    public ResponseEntity<?> update(@PathVariable ObjectId id,
                                    @RequestBody journalentry newmyje,
                                    @PathVariable String username){


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





