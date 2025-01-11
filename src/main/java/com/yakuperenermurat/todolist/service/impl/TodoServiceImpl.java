package com.yakuperenermurat.todolist.service.impl;

import com.yakuperenermurat.todolist.dto.TodoUpdateDTO;
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

    // Tüm To do'ları Getir
    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
    // Tamamlanan To do'ları Getir
    @Override
    public List<Todo> getDoneTodos() {
        return todoRepository.findAll().stream()
                .filter(Todo::isCompleted)
                .toList();
    }

    // Tamamlanmamış To do'ları Getir
    @Override
    public List<Todo> getPendingTodos() {
        return todoRepository.findAll().stream()
                .filter(todo -> !todo.isCompleted())
                .toList();
    }


    // Yeni To do Ekleme
    @Override
    public Todo createTodo(Todo todo) {
        if (todoRepository.existsByTitle(todo.getTitle())) {
            throw new RuntimeException("A todo with the same title already exists.");
        }
        return todoRepository.save(todo);
    }

    // To do Güncelleme
    @Override
    public Todo updateTodo(Long id, TodoUpdateDTO todoDetails) {

        return todoRepository.findById(id)// Optional<To do> döner
                .map(existingTodo -> { // Eğer To do bulunduysa, bu bloğa girer
                    if (!existingTodo.getTitle().equals(todoDetails.getTitle()) &&
                        todoRepository.existsByTitle(todoDetails.getTitle())) {
                        throw new RuntimeException("A todo with the same title already exists. Cannot update.");
                    }
                    existingTodo.setTitle(todoDetails.getTitle());
                    existingTodo.setCompleted(todoDetails.isCompleted());
                    return todoRepository.save(existingTodo);  // Güncellenmiş To do kaydedilir
                })
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id)); // Eğer bulunmazsa hata fırlatır
    }

    // To do Sil
    @Override
    public void deleteTodoById(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new RuntimeException("Todo not found with id: " + id);
        }
        todoRepository.deleteById(id);
    }

    // Tamamlanan To do'ları Sil
    @Override
    public void deleteCompletedTodos() {
        List<Todo> completedTodos = todoRepository.findAll()
                .stream()
                .filter(Todo::isCompleted)
                .toList();
        todoRepository.deleteAll(completedTodos);
    }

    // Tüm To do'ları Sil
    @Override
    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }
}
