package ru.sky.jrtesttask.model;

public class Component {
    private  String name;
    private  boolean need;
    private  int count;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setNeed(boolean need) {
        this.need = need;
    }

    public void setCount(int count) {
        this.count = count;
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
