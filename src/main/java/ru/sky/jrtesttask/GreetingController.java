package ru.sky.jrtesttask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sky.jrtesttask.dao.ComponentDaoImpl;

@Controller
public class GreetingController {
    @Autowired
    private ComponentDaoImpl componentDaoImpl;

    /**
     *
     * @param model
     * @return listmodel in parts.html
     */
    @GetMapping("/parts")
    public String parts( Model model) {
        model.addAttribute("parts", componentDaoImpl.getAllComponents());
        return "parts";
        //TODO https://www.baeldung.com/spring-thymeleaf-conditionals
    }

}