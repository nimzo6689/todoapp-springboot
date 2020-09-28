package com.example.todo.controller;

import java.util.List;

import com.example.todo.common.Utils;
import com.example.todo.model.TodoItem;
import com.example.todo.service.TodoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoHomeController {

    private static final Logger logger = LoggerFactory.getLogger(TodoHomeController.class);

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
        logger.info("index. isCompleted=" + isCompleted + ", todo count is " + todos.size());

        return "index";
    }

    @PostMapping("/create-todo")
    public String createTodo(TodoItem todo) {

        this.todoService.createTodo(todo);
        logger.info("create. " + todo.toString());

        return "redirect:/";
    }

    @PostMapping("/clear-completed")
    public String clearCompleted() {

        int deletedCount = this.todoService.deleteCompleted();
        logger.info(deletedCount + " items are deleted.");

        return "redirect:/";
    }
}
