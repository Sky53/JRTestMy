package ru.sky.jrtesttask.model;

public class Component {
    private final String name;
    private final boolean need;
    private final int count;

    public Component(String name, boolean need, int count) {
        this.name = name;
        this.need = need;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public boolean isNeed() {
        return need;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Component{" +
                "name='" + name + '\'' +
                ", need=" + need +
                ", count=" + count +
                '}';
    }
}
