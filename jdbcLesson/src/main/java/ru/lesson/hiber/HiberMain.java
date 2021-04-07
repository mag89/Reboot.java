package ru.lesson.hiber;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberMain {
    public static void main(String[] args) {
        SessionFactory factory = null;
        SessionFactory factoryH2 = null;
//       final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernateSqlite.cfg").build();

        try {
//            InitializerSqliteDb initializerSqliteDb = new InitializerSqliteDb();
//            initializerSqliteDb.initializeDb();
            factory = new Configuration().configure().buildSessionFactory();
//            factory2 = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
//            StandardServiceRegistryBuilder.destroy(registry);
            e.printStackTrace();
        }
    }
}
