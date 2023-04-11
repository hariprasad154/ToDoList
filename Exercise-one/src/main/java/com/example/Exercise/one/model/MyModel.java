package com.example.Exercise.one.model;


import com.example.Exercise.one.dto.MyDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class MyModel {
    public MyModel(MyDto myDto) {
        this.name = myDto.name;
        this.description = myDto.description;

    }

    public MyModel() {

    }

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private boolean completed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
