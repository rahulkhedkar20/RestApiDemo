package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
}

