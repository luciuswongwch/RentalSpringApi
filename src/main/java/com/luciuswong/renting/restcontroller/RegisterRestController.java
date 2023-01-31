package com.luciuswong.renting.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterRestController {
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public ResponseEntity registerUser() {
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
