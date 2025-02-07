package io.coderproblem.journalwithdatabase.services;

import io.coderproblem.journalwithdatabase.entity.journalentry;
import io.coderproblem.journalwithdatabase.entity.user;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import io.coderproblem.journalwithdatabase.repository.journalrepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class journalservice {

    @Autowired
    private journalrepo journalrepo;

@Autowired
public userservice userservice;
    

//@Transactional
//    public void savejournal(journalentry journalentries, String usernameforjournal){
//     user byuser= userservice.findByusername(usernameforjournal);
//        if (byuser == null) {
//            throw new IllegalArgumentException("User not found with username: " + usernameforjournal);
//        }
////     journalentries.setDate(LocalDateTime.now());
//        journalentry saved = journalrepo.save(journalentries);
//        byuser.getJournalentries().add(saved);
//        userservice.savejournal(byuser);
//
//    }

    @Transactional
    public void savejournal(journalentry journalentries, String usernameforjournal){
        try {

            user byuser= userservice.findByusername(usernameforjournal);
            if (byuser == null) {
                throw new IllegalArgumentException("User not found with username: " + usernameforjournal);
            }
//     journalentries.setDate(LocalDateTime.now());
            journalentry saved = journalrepo.save(journalentries);
            byuser.getJournalentries().add(saved);
//            byuser.setUsername(null);
            userservice.savejournal(byuser);


        }catch (Exception  e){
            System.out.println(e);

            throw new RuntimeException("error while saveing inn given username  :",e);
        }

    }


    public void savejournal(journalentry journalentries){
////        user byuser= userservice.findByusername(usernameforjournal);
//        if (byuser == null) {
//            throw new IllegalArgumentException("User not found with username: " + usernameforjournal);
//        }
////     journalentries.setDate(LocalDateTime.now());
//        journalentry saved = journalrepo.save(journalentries);
//        byuser.getJournalentries().add(saved);
        try {

            journalrepo.save(journalentries);
        }catch (Exception e){
            System.out.println("error :"+e);

        }

    }

    public List <journalentry> seewithGET(){
        return journalrepo.findAll();
    }
    public Optional <journalentry> seewithid(ObjectId oid){
        return  journalrepo.findById(oid);
    }
    public void deletewithid(ObjectId id, String username){
        user byuser= userservice.findByusername(username);
        byuser.getJournalentries().removeIf(x ->x.getId().equals(id));
        userservice.savejournal(byuser);
        journalrepo.deleteById(id);
//        return ;
    }
}
