package com.example.todo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.todo.model.TodoItem;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    public List<TodoItem> getTodoItemList() {

        List<TodoItem> retVal = new ArrayList<>();
        retVal.add(new TodoItem(1L, "やること１", false));
        retVal.add(new TodoItem(2L, "やること２", true));
        retVal.add(new TodoItem(3L, "やること３", false));

        return retVal;
    }
}
