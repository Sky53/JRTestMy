package ru.sky.jrtesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sky.jrtesttask.UpdateComponentRequest;
import ru.sky.jrtesttask.dao.ComponentRepository;
import ru.sky.jrtesttask.model.Component;

import java.util.List;

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



    @RequestMapping(value = "/updateTest/{id}", method = RequestMethod.POST)
    public String updateComponentTest(@RequestBody UpdateComponentRequest request) {
        Component component = componentRepository.findById(request.getId()).get();
        component.setName(request.getName());
        component.setNeed(request.getNeed());
        component.setCount(request.getCount() + 1);
        componentRepository.save(component);

        return "redirect:/parts";
    }
    

}

