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
import ru.sky.jrtesttask.dao.ComponentDaoImpl;
import ru.sky.jrtesttask.dao.ComponentRepository;
import ru.sky.jrtesttask.model.Component;

@Controller
public class GreetingController {

    @Autowired
    private ComponentRepository componentRepository;


    /**
     * @param model
     * @return listmodel in parts.html
     */
    @GetMapping("/parts")
    public String parts(Model model) {
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

        return "parts";
    }

    @PostMapping("/main/{component}")
    public String updateComponent(@RequestParam("id") Component component,
                                  @RequestParam("name") String nameComponent,
                                  @RequestParam("need") Boolean needComponent,
                                  @RequestParam("count") Integer countComponent,
                                  Model model,
                                  Pageable pageable) {

        component.setName(nameComponent);
        component.setNeed(needComponent);
        component.setCount(countComponent);
        componentRepository.save(component);
        Page<Component> components = componentRepository.findAll(pageable);
        model.addAttribute("parts", components);
        return "parts";

    }

    @PostMapping("/main/{component}")
    public String removeComponent(@RequestParam("id") Component component,
                                  Model model,
                                  Pageable pageable) {
        componentRepository.delete(component);
        Page<Component> components = componentRepository.findAll(pageable);
        model.addAttribute("parts", components);
        return "parts";
    }

}