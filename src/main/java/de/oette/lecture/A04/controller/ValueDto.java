package de.oette.lecture.A04.controller;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ValueDto {
    @Min(value = 1)
    @Max(value = 100)
    public Long value;

    @Valid
    @NotNull
    private SubValueDto subValueDto;

    public SubValueDto getSubValueDto() {
        return subValueDto;
    }

    public void setSubValueDto(SubValueDto subValueDto) {
        this.subValueDto = subValueDto;
    }
}
