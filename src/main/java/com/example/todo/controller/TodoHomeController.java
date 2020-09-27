package com.example.todo.controller;

import java.util.List;

import com.example.todo.model.TodoItem;
import com.example.todo.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoHomeController {

    private final TodoService todoService;

    @Autowired
    public TodoHomeController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String index(Model model) {

        List<TodoItem> todos = this.todoService.getTodoItemList();
        model.addAttribute("todos", todos);

        return "index";
    }

    @PostMapping("/create-todo")
    public String createTodo(Model model) {
        return "redirect:/";
    }

    @PostMapping("/clear-completed")
    public String clearCompleted() {

        System.out.println("clear-completed is called.");
        return "redirect:/";
    }
}
