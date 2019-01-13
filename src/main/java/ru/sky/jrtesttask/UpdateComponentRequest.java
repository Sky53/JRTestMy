package ru.sky.jrtesttask;

public class UpdateComponentRequest {

    private  Integer id;

    private  String name;

    private Boolean need;

    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNeed() {
        return need;
    }

    public void setNeed(Boolean need) {
        this.need = need;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "UpdateComponentRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", need=" + need +
                ", count=" + count +
                '}';
    }
}
