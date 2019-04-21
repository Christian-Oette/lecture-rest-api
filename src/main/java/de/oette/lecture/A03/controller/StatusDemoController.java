package de.oette.lecture.A03.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/status")
public class StatusDemoController {

    @GetMapping(value = "200")
    @ResponseStatus(code = HttpStatus.OK)
    public String status200() {
        return "Ok";
    }

    @GetMapping(value = "404")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public String status404() {
        return "Not found";
    }

    @GetMapping(value = "500")
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public String status500() {
        return "Server Error";
    }
}
