package com.hello.hi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {


//    @GetMapping("/hello/{name}/{age}")
    @GetMapping("/hello")
//    String name="hello";
//    int age=60;

    public String insert() {

        // Print and display name and age
//        System.out.println(name);
//        System.out.println(age);
        return "hooooo";
    }

}


