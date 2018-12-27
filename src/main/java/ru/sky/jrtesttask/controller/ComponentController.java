package ru.sky.jrtesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ru.sky.jrtesttask.service.ComponentService;

@Controller
public class ComponentController {
    private final int PAGING  = 10;

    private ComponentService componentService;

    private int defaultfilter = 1;

//    @Autowired()
//    @Qualifier(value = "componentService")
    public void setComponentService(ComponentService componentService) {
        this.componentService = componentService;
    }
}
