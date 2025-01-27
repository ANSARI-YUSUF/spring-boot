package com.hello.hi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myclass {
    @GetMapping("abc")
    public  String hsyhello(){
        return "hello";
    }
}
