package ru.lesson.hiber.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.lesson.hiber.Cpu;

import java.util.List;

public class CpuDao implements Dao<Cpu> {
    private SessionFactory factory;

    public CpuDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Cpu cpu) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(cpu);
            session.getTransaction().commit();
        }
    }

    @Override
    public Cpu read(Cpu entity) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Cpu result = session.get(Cpu.class, entity.getId());
            return result;
        }
    }

    @Override
    public Cpu read(int id) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Cpu result = session.get(Cpu.class, id);
            return result;
        }
    }

    @Override
    public void update(Cpu cpu) {

    }

    @Override
    public void delete(Cpu cpu) {

    }

    @Override
    public List<Cpu> selectStarFromTable() {
        return null;
    }


}
