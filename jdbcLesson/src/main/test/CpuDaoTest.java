import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.lesson.hiber.Cpu;
import ru.lesson.hiber.Provider;

import static org.junit.jupiter.api.Assertions.*;

class CpuDaoTest {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
            configure("testHibernate.cfg.xml").build();
     SessionFactory factory;

    @BeforeEach
    void setUp() {
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            e.printStackTrace();
        }

        Provider provider = new Provider();
        provider.setName("AMD");

        Cpu cpu = new Cpu();
        cpu.setSocket("AM4");
        cpu.setProvider_id(1);
        cpu.setModel("3600SuperPowerXT");
        cpu.setCoresQuantity(12);
        cpu.setCoreFrequency(4000);
    }

    @AfterEach
    void tearDown() {
    }


    /**persist transient entity**/
    @Test
    void persistTransientEntity() {

    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void selectStarFromTable() {
    }
}