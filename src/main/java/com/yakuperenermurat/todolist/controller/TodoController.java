package com.yakuperenermurat.todolist.controller;

import com.yakuperenermurat.todolist.dto.TodoCreateDTO;
import com.yakuperenermurat.todolist.dto.TodoUpdateDTO;
import com.yakuperenermurat.todolist.entity.Todo;
import com.yakuperenermurat.todolist.response.ApiResponse;
import com.yakuperenermurat.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor// Lombok anotasyonu, tüm final değişkenler için constructor (yapıcı metod) oluşturur.
public class TodoController {

    private final TodoService todoService;

    // Tüm To do'ları Listeleme
    @GetMapping
    public ResponseEntity<ApiResponse<List<Todo>>> getAllTodos() {
        return ResponseEntity.ok(new ApiResponse<>(true, "Todos fetched successfully", todoService.getAllTodos()));
    }
    // Tamamlanan To do'ları Listeleme (DONE)
    @GetMapping("/done")
    public ResponseEntity<ApiResponse<List<Todo>>> getDoneTodos() {
        return ResponseEntity.ok(new ApiResponse<>(true, "Completed todos fetched successfully", todoService.getDoneTodos()));
    }

    // Tamamlanmamış To do'ları Listeleme (TODO)
    @GetMapping("/todo")
    public ResponseEntity<ApiResponse<List<Todo>>> getPendingTodos() {
        return ResponseEntity.ok(new ApiResponse<>(true, "Pending todos fetched successfully", todoService.getPendingTodos()));
    }

    // Yeni To do Ekleme
    @PostMapping
    public ResponseEntity<ApiResponse<Todo>> createTodo(@RequestBody TodoCreateDTO todoCreateDTO) {
        Todo todo = new Todo();
        todo.setTitle(todoCreateDTO.getTitle());
        todo.setCompleted(false);
        Todo createdTodo = todoService.createTodo(todo);
        return ResponseEntity.ok(new ApiResponse<>(true, "Todo created successfully", createdTodo));
    }

    // Bir To do Güncelleme
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Todo>> updateTodo(@PathVariable Long id, @RequestBody TodoUpdateDTO todoUpdateDTO) {
        Todo updatedTodo = todoService.updateTodo(id, todoUpdateDTO );
        return ResponseEntity.ok(new ApiResponse<>(true, "Todo updated successfully", updatedTodo));
    }

    // Bir To do Silme
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Todo deleted successfully"));
    }

    // Tamamlanan To do'ları Silme
    @DeleteMapping("/delete-completed")
    public ResponseEntity<ApiResponse<Void>> deleteCompletedTodos() {
        todoService.deleteCompletedTodos();
        return ResponseEntity.ok(new ApiResponse<>(true, "Completed todos deleted successfully"));
    }

    // Tüm To do'ları Silme
    @DeleteMapping("/delete-all")
    public ResponseEntity<ApiResponse<Void>> deleteAllTodos() {
        todoService.deleteAllTodos();
        return ResponseEntity.ok(new ApiResponse<>(true, "All todos deleted successfully"));
    }
}
