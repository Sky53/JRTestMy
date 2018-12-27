package ru.sky.jrtesttask.service;

import ru.sky.jrtesttask.dao.ComponentDao;

import ru.sky.jrtesttask.model.Component;

import java.util.List;


public class ComponentServiceImpl implements ComponentService {

    private ComponentDao componentDao;


    @Override
    public void addComponent(Component component) {
        componentDao.addComponent(component);
    }

    @Override
    public void updateComponent(Component component) {
        componentDao.updateComponent(component);

    }

    @Override
    public void deleteComponent(Component component) {
        componentDao.deleteComponent(component);
    }

    @Override
    public Component getComponentById(int id) {
        return componentDao.getComponentById(id);
    }

    @Override
    public List<Component> getComponentByName(String name) {
        return componentDao.getComponentByName(name);
    }

    @Override
    public List<Component> getAllComponentList() {
        return componentDao.getAllComponentList();
    }

    @Override
    public List<Component> getFilterComponentList(boolean need) {
        return componentDao.getFilterComponentList(need);
    }
}