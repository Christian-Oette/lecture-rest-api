package de.oette.lecture.A02.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/todo")
public class TodoApp2Controller {

    private Map<Integer, TaskDto> todos = new HashMap<>();

    @GetMapping
    public Collection<TaskDto> list() {
        return todos.values();
    }

    @PostMapping
    public Integer add(@RequestBody TaskDto task) {
        Integer newPosition = todos.entrySet().stream()
                .map(Map.Entry::getKey).reduce(Integer::max)
                .orElse(0) + 1;


        todos.put(newPosition, task);
        return newPosition;
    }

    @PutMapping
    public void update(@RequestParam(value = "todo") TaskDto todo,
                       @RequestParam Integer position) {
        TaskDto currentTask = todos.get(position);
        currentTask.description = todo.description;
        currentTask.dueAt = todo.dueAt;
        currentTask.version++;
    }

    @DeleteMapping
    public void delete(@RequestParam Integer position) {
        todos.remove(position);
    }

}
