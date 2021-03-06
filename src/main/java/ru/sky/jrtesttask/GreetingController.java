package ru.sky.jrtesttask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sky.jrtesttask.dao.ComponentRepository;
import ru.sky.jrtesttask.model.Component;

import java.util.List;

@Controller
public class GreetingController {

    @Autowired
    private ComponentRepository componentRepository;


    @GetMapping("/parts")
    public String getComponents(@PageableDefault(size = 10) Pageable pageable, Model model) {
        Page<Component> page = componentRepository.findAll(pageable);
        model.addAttribute("parts", page);


        model.addAttribute("colvo", getMaxValueAssembyComponent());
        return "parts";
    }

    @GetMapping("/findByName")
    public String getComponentForName(@RequestParam String name,
                                      Model model,
                                      @PageableDefault(size = 10) Pageable pageable) {
        if (name.isEmpty()) {
            Page<Component> components = componentRepository.findAll(pageable);
            model.addAttribute("parts", components);


            model.addAttribute("colvo", getMaxValueAssembyComponent());


            return "parts";
        }
        Page<Component> page = componentRepository.findAllByNameLikeIgnoreCase(name, pageable);
        model.addAttribute("parts", page);

        model.addAttribute("colvo", getMaxValueAssembyComponent());

        return "parts";
    }

    @GetMapping("/findByNeed")
    public String getComponentForNeed(Model model, @PageableDefault(size = 10) Pageable pageable) {
        Page<Component> page = componentRepository.findAllByNeedTrue(pageable);
        model.addAttribute("parts", page);
        model.addAttribute("colvo", getMaxValueAssembyComponent());
        return "findByNeed";
    }

    @GetMapping("/findByNotNeed")
    public String getComponentForNotNeed(Model model, @PageableDefault(size = 10) Pageable pageable) {
        Page<Component> page = componentRepository.findAllByNeedFalse(pageable);
        model.addAttribute("parts", page);
        model.addAttribute("colvo", getMaxValueAssembyComponent());
        return "findByNotNeed";
    }

    @PostMapping("/main")
    public String add(@RequestParam String name,
                      @RequestParam Boolean need,
                      @RequestParam Integer count,
                      Model model,
                      @PageableDefault(size = 10) Pageable pageable) {
        Component component = new Component(name, need, count);
        componentRepository.save(component);
        Page<Component> components = componentRepository.findAll(pageable);
        model.addAttribute("parts", components);

        return "redirect:/parts";
    }

    @PostMapping(value = "/updates")
    public String updateComponent(@RequestParam Integer id,
                                  @RequestParam String name,
                                  @RequestParam Boolean need,
                                  @RequestParam Integer count) {

        Component component = componentRepository.findById(id).get();
        component.setName(name);
        component.setNeed(need);
        component.setCount(count);
        componentRepository.save(component);

        return "redirect:/parts";

    }

    public Integer getMaxValueAssembyComponent() {
        Integer maxValue = Integer.MAX_VALUE;
        List<Component> allByNeedTrue = componentRepository.findAllByNeedTrue();
        if (allByNeedTrue.isEmpty()) {
            maxValue = 0;
        } else {
            for (Component component : allByNeedTrue) {
                if (maxValue > component.getCount()) {
                    maxValue = component.getCount();
                }
            }
        }
        return maxValue;
    }

}