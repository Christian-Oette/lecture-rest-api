package de.oette.lecture.A04.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping(value = "/validation")
@Validated
public class ValidationDemoController {

    @PostMapping
    public boolean addValue(@RequestParam(value = "value")
                                        @Min(value = 1) @Max(value = 100) Long value) {
        return true;
    }

    @PostMapping(value = "add2")
    public boolean addValue2(@RequestBody @Valid ValueDto valueDto) {
        return true;
    }
}
