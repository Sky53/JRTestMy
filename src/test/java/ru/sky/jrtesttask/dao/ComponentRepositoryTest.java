package ru.sky.jrtesttask.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import ru.sky.jrtesttask.AbstractTest;
import ru.sky.jrtesttask.model.Component;

import java.util.List;

@Transactional
public class ComponentRepositoryTest extends AbstractTest {

    @Autowired
    ComponentRepository repository;


    @Test
    public void shouldReturnAllComponents() {
        List<Component> components = repository.findAll();
        Assert.assertEquals(25, components.size());

        Component component = components.get(0);

        Assert.assertEquals(Integer.valueOf(1), component.getId());
        Assert.assertEquals("HDD", component.getName());
        Assert.assertEquals(Boolean.TRUE, component.getNeed());
        Assert.assertEquals(Integer.valueOf(3), component.getCount());

    }

    @Test
    public void shouldPaginationValid() {
        Page<Component> components = repository.findAll(PageRequest.of(0, 10, new Sort(Sort.Direction.ASC, "id")));

        Assert.assertEquals(10, components.getSize());
        // TODO Дописать тест, Дописать тест на имя,
    }

    @Test
    public void shouldFindbyName() {
        Page<Component> components = repository.findAllByNameLike("HDD", PageRequest.of(0, 100));

        Assert.assertEquals("HDD",components.getContent().get(0).getName());

    }
    @Test
    public void  shouldFindByNeedFolse(){
        Page<Component> componentPage = repository.findAllByNeedFalse(PageRequest.of(0,10));
        Assert.assertEquals("SSD",componentPage.getContent().get(0).getName());
    }

    @Test
    public void souldFindByNeedTrue(){
        Page<Component> componentPage = repository.findAllByNeedTrue(PageRequest.of(0,10));
        Assert.assertEquals("HDD",componentPage.getContent().get(0).getName());
    }
}
