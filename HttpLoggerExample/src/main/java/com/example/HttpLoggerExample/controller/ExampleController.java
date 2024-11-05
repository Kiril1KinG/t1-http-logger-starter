package com.example.HttpLoggerExample.controller;

import com.example.HttpLoggerExample.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class ExampleController {

    @GetMapping
    public ResponseEntity<User> getUser() {
        return new ResponseEntity<>(new User(1, "user", "user@email.ru"), HttpStatus.OK);
    }
}
