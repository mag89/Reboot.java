package ru.lesson.hiber;

import javax.persistence.*;

@Entity
@Table(name = "CPU")
public class Cpu {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    @ManyToOne(targetEntity = CpuProvider.class, cascade = CascadeType.ALL)
    private CpuProvider provider;
    @Column(unique = true)
    private String model;
    @Column
    private int coresQuantity;
    @Column
    private int coreFrequency;
    @Column
    private String socket;


    public CpuProvider getProvider() {
        return provider;
    }

    public void setProvider(CpuProvider provider) {
        this.provider = provider;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCoresQuantity() {
        return coresQuantity;
    }

    public void setCoresQuantity(int coresQuantity) {
        this.coresQuantity = coresQuantity;
    }

    public int getCoreFrequency() {
        return coreFrequency;
    }

    public void setCoreFrequency(int coreFrequency) {
        this.coreFrequency = coreFrequency;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    @Override
    public String toString() {
        return String.format("Cpu{id=%n, provider=%s, model=%s, coresQuantity=%n, coreFrequency=%n, socket=%s",
                id, provider, model, coresQuantity, coreFrequency, socket);
    }
}
