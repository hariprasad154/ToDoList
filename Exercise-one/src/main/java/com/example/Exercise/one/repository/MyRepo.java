package com.example.Exercise.one.repository;

import com.example.Exercise.one.model.MyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepo extends JpaRepository<MyModel,Long> {

}
