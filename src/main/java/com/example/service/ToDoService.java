package com.example.service;

import com.example.dao.ToDoDao;
import com.example.model.Person;
import com.example.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ToDoService {

    private final ToDoDao todoDao;

    @Autowired
    public ToDoService(@Qualifier("datalist") ToDoDao todoDao) {
        this.todoDao = todoDao;
    }

    public int addTodo(ToDo todo) {
        return todoDao.addTodo(todo);
    }

    public List<ToDo> getAllTodos() {
        return todoDao.selectAllTodos();
    }

    public Optional<ToDo> getTodoById(UUID id) {
        return todoDao.selectTodoById(id);
    }

    public int deleteTodo(UUID id){
        return todoDao.deleteTodoById(id);
    }

    public int updateTodo(UUID id, ToDo newTodo) {
        return todoDao.updateTodoById(id, newTodo);
    }
}
