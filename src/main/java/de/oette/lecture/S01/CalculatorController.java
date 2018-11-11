package de.oette.lecture.S01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    Integer currentValue = 0;

    @GetMapping
    public Integer get() {
        return currentValue;
    }

    @PostMapping(value = "add")
    public Integer add(Integer value) {
        currentValue = currentValue + value;
        return currentValue;
    }


    @PostMapping(value = "subtract")
    public Integer subtract(Integer value) {
        currentValue = currentValue - value;
        return currentValue;
    }

    @PostMapping
    public Integer setValue(Integer value) {
        currentValue = value;
        return currentValue;
    }
}
