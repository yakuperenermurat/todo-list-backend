package com.yakuperenermurat.todolist.service;

import com.yakuperenermurat.todolist.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo createTodo(Todo todo);
    Todo updateTodo(Long id, Todo todo);
    void deleteTodoById(Long id);
}