package de.oette.lecture.A03.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/{id}")
    public UserDto getById(@PathVariable(value = "id") long id) {
        if (id == 1) {
            UserDto userDto = new UserDto();
            userDto.name = "Max";
            return userDto;
        }

        if (id == 7) {
            throw new IllegalArgumentException("Id 7 not allowed");
        }

        throw new UserNotFoundException(String.format("User with id %s not found", id));
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ErrorDto handleNotFoundException(UserNotFoundException ex) {
        return new ErrorDto(ex.getMessage());
    }
}
