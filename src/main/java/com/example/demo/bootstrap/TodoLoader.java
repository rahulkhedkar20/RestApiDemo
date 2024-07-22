package com.example.demo.bootstrap;

import java.sql.Timestamp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Todo;
import com.example.demo.model.TodoStatus;
import com.example.demo.repositories.TodoRepository;

import jakarta.annotation.PostConstruct;

@Component
public class TodoLoader {
    public final TodoRepository todoRepository;

    public TodoLoader(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    
    @PostConstruct
    public void init(){
    	System.out.println("************ inside init() Method got called");
    	loadTodos();
    }

    private void loadTodos() {
    	System.out.println("************ Method got called");
        if (todoRepository.count() == 0) {
        	System.out.println("************ inside Method got called");
        	// Long id, String title, String description, TodoStatus todoStatus, Timestamp dateCreated,
		
			todoRepository.save(new Todo(1, "Title 1", "Description", TodoStatus.COMPLETED,
					new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
            todoRepository.save(new Todo(2, "Title 2", "Description", TodoStatus.COMPLETED,
					new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
            todoRepository.save(new Todo(3, "Title 3", "Description", TodoStatus.COMPLETED,
					new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
            System.out.println("Sample Todos Loaded");
        }
    }
}
