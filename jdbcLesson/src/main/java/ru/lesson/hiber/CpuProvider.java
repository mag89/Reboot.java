package ru.lesson.hiber;

import javax.persistence.*;

@Entity
@Table(name = "CPU_PROVIDER")
public class CpuProvider {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("CpuProvider{id=%n, provider=%s}", id, name);
    }
}
