package com.example.dao;

import com.example.model.ToDo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DefaultTodoDataAccessService implements ToDoDao {

    private static List<ToDo> DB = new ArrayList<>();

    @Override
    public int addTodo(UUID id, ToDo todo) {
        DB.add(new ToDo(id, todo.getTitle(), todo.getText()));
        return 1;
    }

    @Override
    public List<ToDo> selectAllTodos() {
        return DB;
    }

    @Override
    public Optional<ToDo> selectTodoById(UUID id) {
        return DB.stream()
                .filter(todo -> todo.getUuid().equals(id))
                .findFirst();
    }

    @Override
    public int deleteTodoById(UUID id) {
        Optional<ToDo> todoMaybe = selectTodoById(id);
        if(todoMaybe.isEmpty()) {
            DB.remove(todoMaybe.get());
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updateTodoById(UUID id, ToDo update) {
        return selectTodoById(id)
                .map(todo -> {
                    int indexTodoToBeUpdated = DB.indexOf(todo);
                    if(indexTodoToBeUpdated >= 0) {
                        DB.set(indexTodoToBeUpdated, new ToDo(id, update.getTitle(), update.getText()));
                        return 2;
                    } else {
                        return 0;
                    }
                }).orElse(0);
    }
}
