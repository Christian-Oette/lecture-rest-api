package de.oette.lecture.A01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HelloWorldController {

    @GetMapping
    public String hello(@RequestParam String text) {
        if (text!=null)  {
            return "You entered: "+text;
        }

        return "Application is up and running. ";
    }


}
