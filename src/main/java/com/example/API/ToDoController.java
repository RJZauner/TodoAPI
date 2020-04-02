package com.example.API;

import com.example.model.ToDo;
import com.example.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/todo")
@RestController
public class ToDoController {

    private final ToDoService todoService;

    @Autowired
    public ToDoController(ToDoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public void insertTodo(ToDo todo){
        todoService.addTodo(todo);
    }

    @GetMapping
    public List<ToDo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @GetMapping
    public ToDo getTodoById(@PathVariable("id") UUID id){
        return todoService.getTodoById(id)
                .orElse(null);
    }

    @DeleteMapping
    public void deleteTodoById(@PathVariable("id") UUID id){
        todoService.deleteTodo(id);
    }

    @PutMapping
    public void updateTodoById(@PathVariable UUID id, ToDo todoToUpdate){
        todoService.updateTodo(id, todoToUpdate);
    }
}
