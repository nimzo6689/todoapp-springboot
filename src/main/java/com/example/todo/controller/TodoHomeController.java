package com.example.todo.controller;

import java.util.List;

import com.example.todo.common.Utils;
import com.example.todo.model.TodoItem;
import com.example.todo.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoHomeController {

    private final TodoService todoService;

    @Autowired
    public TodoHomeController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String index(@RequestParam(name = "is_completed", required = false) Integer isCompleted, Model model) {

        // 新規作成用のTodoインスタンスを生成
        model.addAttribute("newTodo", new TodoItem());
        model.addAttribute("isCompleted", isCompleted);

        // Todoリストを取得
        List<TodoItem> todos;
        if (isCompleted == null) {
            todos = this.todoService.getTodoItemList();
        } else {
            todos = this.todoService.getTodoItemListFilteredByComleted(Utils.convertToBool(isCompleted));
        }
        model.addAttribute("todos", todos);

        return "index";
    }

    @PostMapping("/create-todo")
    public String createTodo(TodoItem todo) {

        this.todoService.createTodo(todo);

        return "redirect:/";
    }

    @PostMapping("/clear-completed")
    public String clearCompleted() {

        int deletedCount = this.todoService.deleteCompleted();
        System.out.println(deletedCount + " items are deleted.");

        return "redirect:/";
    }
}
