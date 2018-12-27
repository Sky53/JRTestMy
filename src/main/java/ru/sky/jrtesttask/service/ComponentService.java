package ru.sky.jrtesttask.service;

import ru.sky.jrtesttask.model.Component;

import java.util.List;

public interface ComponentService {
    void addComponent(Component component);
    void updateComponent(Component component);
    void deleteComponent(Component component);
    Component getComponentById(int id);
    List<Component> getComponentByName(String name);
    List<Component> getAllComponentList();
    List<Component> getFilterComponentList(boolean need);
}
