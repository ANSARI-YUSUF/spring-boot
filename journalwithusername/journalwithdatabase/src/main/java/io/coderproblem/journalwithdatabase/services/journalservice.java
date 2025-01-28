package io.coderproblem.journalwithdatabase.services;

import io.coderproblem.journalwithdatabase.entity.journalentry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import io.coderproblem.journalwithdatabase.repository.journalrepo;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class journalservice {

    @Autowired
    private journalrepo journalrepo;


    public void savejournal(journalentry journalentries){
        journalrepo.save(journalentries);
    }

    public List <journalentry> seewithGET(){
        return journalrepo.findAll();
    }
    public Optional <journalentry> seewithid(ObjectId oid){
        return  journalrepo.findById(oid);
    }
    public void deletewithid(ObjectId id){
        journalrepo.deleteById(id);
//        return ;
    }
}
