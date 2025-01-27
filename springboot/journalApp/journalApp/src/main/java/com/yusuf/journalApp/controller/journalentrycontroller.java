package com.yusuf.journalApp.controller;

import com.yusuf.journalApp.entity.journalentry;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class journalentrycontroller {

    private Map<Long, journalentry> je =new HashMap();

    @GetMapping
    public List<journalentry> gellantry(){
        return new ArrayList<>(je.values());
//        localhost:8080/journal for GET
    }
    @PostMapping
    public boolean createentry(@RequestBody journalentry me){
//        localhost:8080/journal for post

        je.put(me.getId(),me);
        return true;
    }
    @GetMapping("/id/{myid}")
    public journalentry getentrybyid(@PathVariable Long myid){

        return  je.get(myid);

    }

    @DeleteMapping("/id/{myid}")
    public journalentry deleteentrybyid(@PathVariable Long myid){

        return  je.remove(myid);

    }
    @PutMapping("/id/{id}")
    public journalentry update(@PathVariable Long id, @RequestBody journalentry myje){
        return je.put(id,myje);
    }
}
