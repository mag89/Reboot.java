package ru.lesson.hiber;

import javax.persistence.*;

@Entity
@Table(name = "CPU")
public class Cpu {
    @Id
    @SequenceGenerator(name = "cpu_id", sequenceName = "cpu_id_seq", allocationSize = 0)
    @GeneratedValue(generator = "cpu_id")
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @Column(name = "PROVIDER_ID")
    @ManyToOne(targetEntity = CpuProvider.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    private CpuProvider provider;

    @Column(name = "MODEL", unique = true)
    private String model;

    @Column(name = "CORES_QUANTITY")
    private int coresQuantity;

    @Column(name = "CORE_FREQUENCY")
    private int coreFrequency;

    @Column(name = "SOCKET")
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
