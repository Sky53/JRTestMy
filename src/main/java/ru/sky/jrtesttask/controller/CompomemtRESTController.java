package ru.sky.jrtesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.sky.jrtesttask.dao.ComponentRepository;

@RestController
public class CompomemtRESTController {

    ComponentRepository componentRepository;

    @Autowired
    public CompomemtRESTController(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    @GetMapping("/delete/component/{id}")
    public void removeComponent(@PathVariable("id") Integer id) {
        componentRepository.deleteById(id);
    }

}

