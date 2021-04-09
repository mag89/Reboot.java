import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.lesson.hiber.Cpu;
import ru.lesson.hiber.Provider;
import ru.lesson.hiber.dao.CpuDao;
import ru.lesson.hiber.dao.ProviderDao;

class CpuDaoTest {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
            configure("testHibernate.cfg.xml").build();
    private SessionFactory factory;
    private Cpu cpu;
    private Provider provider;
    private CpuDao cpuDao;
    private ProviderDao providerDao;


    @BeforeEach
    void setUp() {
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            cpuDao = new CpuDao(factory);
            providerDao = new ProviderDao(factory);
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            e.printStackTrace();
        }

        provider = new Provider();
        provider.setName("AMD");

        cpu = new Cpu();
        cpu.setSocket("AM4");
        cpu.setProvider_id(1);
        cpu.setModel("3600SuperPowerXT");
        cpu.setCoresQuantity(12);
        cpu.setCoreFrequency(4000);

    }

    @AfterEach
    void tearDown() {
    }


    /**
     * persist transient entity
     **/
    @Test
    void persistTransientEntity() {
        providerDao.create(provider);
        cpuDao.create(cpu);

        Cpu expected = this.cpu;
        Cpu actual = cpuDao.read(expected.getId());

        Assert.assertEquals(expected, actual);


    }

    @Test
    void persistDetachedEntity() {
        Provider detachedProvider = new Provider();
        detachedProvider.setId(55);
        detachedProvider.setName("I`m detaced provider");

        providerDao.create(detachedProvider);

        int expected = detachedProvider.getId();
        int actual = providerDao.read(55).getId();

        Assert.assertEquals(expected, actual);
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