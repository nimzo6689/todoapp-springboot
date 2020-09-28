package com.example.todo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.todo.model.TodoItem;
import com.example.todo.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(final TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public int createTodo(final TodoItem todoItem) {
        return this.todoRepository.insert(todoItem);
    }

    public List<TodoItem> getTodoItemList() {

        return this.todoRepository.findAll();
    }

    public List<TodoItem> getTodoItemListFilteredByComleted(boolean isCompleted) {
        List<TodoItem> todos = this.getTodoItemList();

        List<TodoItem> retVal = new ArrayList<>();
        for (TodoItem todo : todos) {
            if (todo.getIsCompleted() == isCompleted) {
                retVal.add(todo);
            }
        }

        return retVal;
    }

    public int updateTodo(final TodoItem todoItem) {
        return this.todoRepository.update(todoItem);
    }

    public int deleteTodo(final TodoItem todoItem) {
        return this.todoRepository.deleteById(todoItem.getId());
    }

    public int deleteCompleted() {
        return this.todoRepository.deleteByCompleted(true);
    }
}
