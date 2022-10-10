package com.example.demo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@RequestMapping
public class Validators {
    @Autowired
    List<Validator> validators;

    @GetMapping("/login/{email}/{password}/{name}")
    public void validate(@PathVariable String email,@PathVariable String password,@PathVariable String name){
        for (Validator validator:validators){
            validator.validate(email,password,name);
        }
    }

}
