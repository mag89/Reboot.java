package ru.lesson.hiber.dao;

import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.lesson.hiber.Provider;

import java.util.List;

public class ProviderDao implements Dao<Provider> {
    private SessionFactory factory;

    public ProviderDao(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(Provider provider) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            if (provider.getId() == 0) {
                session.persist(provider);
            }
            session.replicate(provider, ReplicationMode.OVERWRITE);
            session.getTransaction().commit();
        }
    }

    @Override
    public Provider read(Provider entity) {
        return null;
    }

    @Override
    public Provider read(int id) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Provider result = session.get(Provider.class, id);
            return result;
        }
    }

    @Override
    public void update(Provider provider) {

    }

    @Override
    public void delete(Provider provider) {

    }

    @Override
    public List<Provider> selectStarFromTable() {
        return null;
    }
}
