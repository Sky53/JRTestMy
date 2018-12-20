package ru.sky.jrtesttask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sky.jrtesttask.dao.ComponentDao;

@Controller
public class GreetingController {
    @Autowired
    private ComponentDao componentDao;

    @GetMapping("/parts")
    public String parts( Model model) {
        model.addAttribute("parts", componentDao.getAllComponents());
        return "parts";
    }

}