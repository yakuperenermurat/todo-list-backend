package com.yakuperenermurat.todolist.service.impl;

import com.yakuperenermurat.todolist.entity.Todo;
import com.yakuperenermurat.todolist.repository.TodoRepository;
import com.yakuperenermurat.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long id, Todo todoDetails) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setTitle(todoDetails.getTitle());
                    todo.setCompleted(todoDetails.isCompleted());
                    return todoRepository.save(todo);
                })
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    @Override
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
    @Override
    public void deleteCompletedTodos() {
        List<Todo> completedTodos = todoRepository.findAll()
                .stream()
                .filter(Todo::isCompleted)
                .toList();
        todoRepository.deleteAll(completedTodos);
    }

    @Override
    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }
}