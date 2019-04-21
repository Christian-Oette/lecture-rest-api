package de.oette.lecture.A04.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class SubValueDto {
    @Min(value = 1)
    @Max(value = 100)
    public Long value;

    public Long getValue() {
        return value;
    }
}
