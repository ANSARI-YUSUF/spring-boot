package io.coderproblem.journalwithdatabase.services;

import io.coderproblem.journalwithdatabase.entity.journalentry;
import io.coderproblem.journalwithdatabase.entity.user;
import io.coderproblem.journalwithdatabase.repository.journalrepo;
import io.coderproblem.journalwithdatabase.repository.userrepo;
import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userservice {

    @Autowired
//    private journalrepo journalrepo;
    private userrepo userrepo;


    public void savejournal(user users){
        userrepo.save(users);
    }

    public List <user> seewithGET(){
        return userrepo.findAll();
    }
    public Optional <user> seewithid(ObjectId oid){
        return  userrepo.findById(oid);
    }
    public void deletewithid(ObjectId id){
        userrepo.deleteById(id);
//        return ;
    }
    public  user findByusername(String username){
        return  userrepo.findByusername(username);

    }
}
