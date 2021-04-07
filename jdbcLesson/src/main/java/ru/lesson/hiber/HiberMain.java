package ru.lesson.hiber;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.lesson.hiber.dao.CpuDao;
import ru.lesson.hiber.dao.ProviderDao;

public class HiberMain {
    public static void main(String[] args) {
        SessionFactory factory = null;
        SessionFactory factory2 = null;
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

        CpuDao cpuDao = new CpuDao(factory);
        ProviderDao providerDao = new ProviderDao(factory);

        Provider providerIntell = new Provider();
        providerIntell.setName("Intell");
        Cpu cpuExp = new Cpu();
        cpuExp.setCoreFrequency(3800);
        cpuExp.setCoresQuantity(6);
        cpuExp.setModel("10400 Experimental");
        cpuExp.setProvider_id(1);
        cpuExp.setSocket("t50");

        providerDao.create(providerIntell);
        cpuDao.create(cpuExp);
    }
}
