package ru.lesson.hiber;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PROVIDER")
public class Provider {
    @Id
    @SequenceGenerator(name = "provider_id", sequenceName = "provider_id_seq", allocationSize = 0) //not allowed for sqlite
    @GeneratedValue(generator = "provider_id", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @Column(name = "NAME", unique = true)
    private String name;

    @OneToMany
    @JoinColumn(name = "PROVIDER_ID")
    private List<Cpu> cpuModels;


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
