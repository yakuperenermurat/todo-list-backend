package com.yakuperenermurat.todolist.repository;


import com.yakuperenermurat.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    boolean existsByTitle(String title); // veritabanında belirtilen başlıkta (title) bir To do kaydının var olup olmadığını kontrol eder.
}
