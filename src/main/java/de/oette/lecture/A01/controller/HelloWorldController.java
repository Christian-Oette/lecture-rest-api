package de.oette.lecture.A01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HelloWorldController {

    @GetMapping
    public String hello(@RequestParam(required = false, defaultValue = "") String text,
                        @RequestParam(required = false, defaultValue = "") String text2) {
        if (text.isEmpty() && text2.isEmpty())  {
            return "Application is up and running. ";
        }

        return "You entered: "+text + " "+ text2;
    }

}
