package com.luciuswong.renting.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthRestController {
    @GetMapping(path="/basicauth")
    public String basicAuthentication() {
        return "Success";
    }
}
