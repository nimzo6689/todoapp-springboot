package com.example.todo.controller;

import java.util.List;

import com.example.todo.model.TodoItem;
import com.example.todo.service.TodoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoEditController {

    private static final Logger logger = LoggerFactory.getLogger(TodoEditController.class);

    private final TodoService todoService;

    @Autowired
    public TodoEditController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model) {

        List<TodoItem> todos = this.todoService.getTodoItemList();

        for (TodoItem todo : todos) {
            if (todo.getId() == id) {
                model.addAttribute("todo", todo);
                logger.info("edit. " + todo.toString());
                break;
            }
        }

        return "edit";
    }

    @PostMapping("/{id}/update")
    public String update(TodoItem todo) {

        this.todoService.updateTodo(todo);
        logger.info("update. " + todo.toString());

        return "redirect:/";
    }

    @PostMapping("/{id}/complete")
    public String complete(TodoItem todo) {

        todo.setIsCompleted(true);
        this.todoService.updateTodo(todo);
        logger.info("complete. " + todo.toString());

        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String delete(TodoItem todo) {

        this.todoService.deleteTodo(todo);
        logger.info("delete. " + todo.toString());

        return "redirect:/";
    }
}
