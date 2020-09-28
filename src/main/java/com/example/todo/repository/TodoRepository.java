package com.example.todo.repository;

import java.util.List;

import com.example.todo.model.TodoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public TodoRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insert(TodoItem todoItem) {

        String sql = "INSERT INTO todo (title, is_completed) VALUES (:title, :isCompleted)";
        SqlParameterSource param = new BeanPropertySqlParameterSource(todoItem);

        return jdbcTemplate.update(sql, param);
    }

    public TodoItem findById(long id) {

        String sql = "SELECT * FROM todo WHERE id = :id";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

        return this.jdbcTemplate.queryForObject(sql, param, new BeanPropertyRowMapper<>(TodoItem.class));
    }

    public List<TodoItem> findAll() {

        String sql = "SELECT * FROM todo";
        return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TodoItem.class));
    }

    public int update(TodoItem todoItem) {

        String sql = "UPDATE todo SET title = :title, is_completed = :isCompleted WHERE id = :id";
        SqlParameterSource param = new BeanPropertySqlParameterSource(todoItem);

        return jdbcTemplate.update(sql, param);
    }

    public int deleteById(long id) {

        String sql = "DELETE FROM todo WHERE id = :id";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

        return jdbcTemplate.update(sql, param);
    }

    public int deleteByCompleted(boolean isCompleted) {

        String sql = "DELETE FROM todo WHERE is_completed = :isCompleted";
        SqlParameterSource param = new MapSqlParameterSource().addValue("isCompleted", isCompleted);

        return jdbcTemplate.update(sql, param);
    }

}
