package com.example.dao;

import com.example.model.Person;
import com.example.model.ToDo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ToDoDao {

    int addTodo(UUID id, ToDo todo);

    default int addTodo(ToDo todo) {
        UUID id = UUID.randomUUID();
        return addTodo(id, todo);
    }

    //methods for reading, selecting, deleting and updating todos.

    List<ToDo> selectAllTodos();

    Optional<ToDo> selectTodoById(UUID id);

    int deleteTodoById(UUID id);

    int updateTodoById(UUID id, ToDo todo);
}
