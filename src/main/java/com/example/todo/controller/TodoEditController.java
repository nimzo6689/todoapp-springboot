package com.example.todo.controller;

import java.util.List;

import com.example.todo.model.TodoItem;
import com.example.todo.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoEditController {

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
                System.out.println("edit. id=" + id);
                break;
            }
        }

        return "edit";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") String id, Model model) {
        System.out.println("update. id=" + id);
        return "redirect:/";
    }

    @PostMapping("/{id}/complete")
    public String complete(@PathVariable("id") String id, Model model) {
        System.out.println("complete. id=" + id);
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") String id, Model model) {
        System.out.println("delete. id=" + id);
        return "redirect:/";
    }
}
