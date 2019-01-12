package ru.sky.jrtesttask;

public class UpdateComponentRequest {

    private  Integer id;

    private  String name;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UpdateComponentRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
