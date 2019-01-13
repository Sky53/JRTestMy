package ru.sky.jrtesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sky.jrtesttask.UpdateComponentRequest;
import ru.sky.jrtesttask.dao.ComponentRepository;
import ru.sky.jrtesttask.model.Component;

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

//    @GetMapping(value = "/updates/{id}")
//    public void updateComponent(
//                                  @PathVariable("id") Integer id,
//                                  @RequestBody UpdateComponentRequest request) {
//
//        Component component = componentRepository.findById(request.getId()).get();
//        component.setName(request.getName());
//        component.setNeed(request.getNeed());
//        component.setCount(request.getCount());
//        componentRepository.save(component);
//
//    }

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

