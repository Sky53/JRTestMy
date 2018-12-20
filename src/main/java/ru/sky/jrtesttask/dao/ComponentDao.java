package ru.sky.jrtesttask.dao;

import ru.sky.jrtesttask.model.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ComponentDao {

    public List<Component> getAllComponents(){
      return Arrays.asList(new Component("Материнская плата",true,10),
                            new Component("HDD",true,25));
    }


}
