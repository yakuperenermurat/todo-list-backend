package com.yakuperenermurat.todolist.service;

import com.yakuperenermurat.todolist.dto.TodoUpdateDTO;
import com.yakuperenermurat.todolist.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo createTodo(Todo todo);
    Todo updateTodo(Long id, TodoUpdateDTO todoUpdateDTO);
    List<Todo> getDoneTodos();  // Tamamlananları Listele
    List<Todo> getPendingTodos();  // Tamamlanmamışları Listele
    void deleteTodoById(Long id);
    void deleteCompletedTodos();
    void deleteAllTodos();
}