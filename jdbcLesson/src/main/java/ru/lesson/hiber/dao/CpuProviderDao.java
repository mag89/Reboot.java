package ru.lesson.hiber.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.lesson.hiber.CpuProvider;

import java.util.List;

public class CpuProviderDao implements Dao<CpuProvider> {
    private SessionFactory factory;

    public CpuProviderDao(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(CpuProvider cpuProvider) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(cpuProvider);
            session.getTransaction().commit();
        }
    }

    @Override
    public CpuProvider read(String model) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            CpuProvider result = session.get(CpuProvider.class, model);
            return result;
        }
    }

    @Override
    public void update(CpuProvider cpuProvider) {

    }

    @Override
    public void delete(CpuProvider cpuProvider) {

    }

    @Override
    public List<CpuProvider> selectStarFromTable() {
        return null;
    }
}
