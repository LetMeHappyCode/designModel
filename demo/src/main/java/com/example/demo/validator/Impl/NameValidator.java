package com.example.demo.validator.Impl;

import com.example.demo.validator.Validator;
import org.springframework.stereotype.Component;

@Component
public class NameValidator implements Validator {
    @Override
    public void validate(String email, String password, String name) {
        System.out.println("NameValidator");
        if (name == null  || name.length() > 20) {
//            throw new IllegalArgumentException("invalid name: " + name);
        }
    }
}
