package ru.sky.jrtesttask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sky.jrtesttask.dao.ComponentRepository;
import ru.sky.jrtesttask.model.Component;

@Controller
public class GreetingController {

    @Autowired
    private ComponentRepository componentRepository;




    @GetMapping("/test")
    public String test(Page<Component> componentPage) {
        componentPage.getTotalElements();
        return "parts";

    }

    @GetMapping("/parts")
    public String getComponents(@PageableDefault(size = 10) Pageable pageable, Model model) {
        Page<Component> page = componentRepository.findAll(pageable);
        model.addAttribute("parts", page);
        return "parts";
    }

    @PostMapping("/main")
    public String add(@RequestParam String name,
                      @RequestParam Boolean need,
                      @RequestParam Integer count,
                      Model model,
                      Pageable pageable) {
        Component component = new Component(name, need, count);
        componentRepository.save(component);
        Page<Component> components = componentRepository.findAll(pageable);
        model.addAttribute("parts", components);

        return "redirect:/parts";
    }

    @PostMapping("/update")
    public String updateComponent(
            @RequestBody UpdateComponentRequest request) {

             Component component = componentRepository.findById(request.getId()).get();
             component.setName(request.getName());
        componentRepository.save(component);

        return "redirect:/parts";

    }


}