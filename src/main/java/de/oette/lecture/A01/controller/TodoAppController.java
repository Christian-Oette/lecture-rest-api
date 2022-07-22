package de.oette.lecture.A01.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/todo")
public class TodoAppController {

    private Map<Integer, String> todos = new HashMap<>();

    @GetMapping
    public String list() {
        return todos.entrySet().stream()
                .map(x -> String.format("[%s %s]", x.getKey(), x.getValue()))
                .collect(Collectors.joining());

    }

    @PostMapping
    public Integer add(@RequestParam(value = "todo") String todo) {
        Integer newPosition = todos.entrySet().stream()
                .map(Map.Entry::getKey).reduce(Integer::max)
                .orElse(0) + 1;

        todos.put(newPosition, todo);
        return newPosition;
    }

    @PutMapping
    public void update(@RequestParam(value = "todo") String todo,
                       @RequestParam Integer position) {
        todos.put(position, todo);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer position) {
        todos.remove(position);
    }

}
