package com.hello.hi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class car {

    @Autowired
    private dog d;

    @GetMapping("/dog")
    public String k(){
        return d.barks();
    }
}
