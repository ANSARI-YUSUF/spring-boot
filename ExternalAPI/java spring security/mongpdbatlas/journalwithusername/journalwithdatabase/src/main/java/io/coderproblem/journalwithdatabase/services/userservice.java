package io.coderproblem.journalwithdatabase.services;

import io.coderproblem.journalwithdatabase.entity.journalentry;
import io.coderproblem.journalwithdatabase.entity.user;
import io.coderproblem.journalwithdatabase.repository.journalrepo;
import io.coderproblem.journalwithdatabase.repository.userrepo;
import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class userservice {

    @Autowired
//    private journalrepo journalrepo;
    private userrepo userrepo;
    public  PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();


    public void savejournal(user users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
//        userindb.setPassword(passwordEncoder().encode(user.getPassword()));/
//        users.setRoles(Arrays.asList("USER"));
        // Assign a default role only if the user doesn't have one already
        if (users.getRoles() == null || users.getRoles().isEmpty()) {
            users.setRoles(Collections.singletonList("USER"));
        }
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
