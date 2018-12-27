package ru.sky.jrtesttask.model;

import javax.persistence.*;

/**
 * Класс компонент создан для работы с сущностями
 */
@Entity
@Table
public class Component {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Boolean need;

    @Column
    private Integer count;

    protected Component() {

    }

    public Component(String name, Boolean need, Integer count) {
        this.name = name;
        this.need = need;
        this.count = count;
    }

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
        return "Component{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", need=" + need +
                ", count=" + count +
                '}';
    }
}
