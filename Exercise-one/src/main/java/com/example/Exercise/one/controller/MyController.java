package com.example.Exercise.one.controller;

import com.example.Exercise.one.dto.MyDto;
import com.example.Exercise.one.model.MyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Exercise.one.repository.MyRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MyController {
    @Autowired
    private MyRepo myRepo;
    public List<MyModel> getalldata() {
        List<MyModel> data = new ArrayList<>();
        myRepo.findAll().forEach(datas -> data.add(datas));
        return data;
    }
    @PostMapping("/post")
    public MyModel addingData(@RequestBody MyDto mydto){
        MyModel data =new MyModel(mydto);
        return myRepo.save(data);
    }
    @PutMapping("/put/{id}")
    public MyModel update(@RequestBody MyDto mydto, @PathVariable long id) {
        Optional<MyModel> data = myRepo.findById(id);
        if (data.isPresent()) {
            data.get().setName(mydto.name);
            data.get().setDescription(mydto.description);
            return myRepo.save(data.get());
        }
        return null;
    }
    @GetMapping("/get")
    public List<MyModel> getall(){
        return getalldata();
    }
    @DeleteMapping("/delete/{id}")
    public String delet(@PathVariable long id) {
        Optional<MyModel> data = myRepo.findById(id);
        if (data.isPresent()) {
            myRepo.deleteById(id);
            return "The deleting done" +id;
        }
        return null;
    }
}
