package ru.lesson.hiber;

import javax.persistence.*;

@Entity
@Table(name = "CPU_PROVIDER")
public class CpuProvider {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String provider;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return String.format("CpuProvider{id=%n, provider=%s}", id, provider);
    }
}
