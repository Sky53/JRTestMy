package ru.sky.jrtesttask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sky.jrtesttask.dao.ComponentDaoImpl;
import ru.sky.jrtesttask.dao.ComponentRepository;
import ru.sky.jrtesttask.model.Component;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GreetingController {
    @Autowired
    private ComponentDaoImpl componentDaoImpl;

    @Autowired
    private ComponentRepository componentRepository;


    /**
     *
     * @param model
     * @return listmodel in parts.html
     */
    @GetMapping("/parts")
    public String parts( Model model) {
//       model.addAttribute("parts", componentDaoImpl.getAllComponents());
//        model.addAttribute("parts", componentRepository.findAll());
        //List<Component> componentList = componentRepository.findAll();
        model.addAttribute("parts", componentRepository.findAll());


        return "parts";
        //TODO https://www.baeldung.com/spring-thymeleaf-conditionals
    }

    @GetMapping("/test")
    public String test(Page<Component> componentPage) {
        componentPage.getTotalElements();
        return "parts";

    }

    @GetMapping("/page")
    public String getComponents (@PageableDefault(size = 10) Pageable pageable, Model model) {
        Page<Component> page = componentRepository.findAll(pageable);
        model.addAttribute("parts", page);
        return "parts";
    }
}