package mag.springLearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ReservationRepository rr) {
        return args -> {
            Arrays.asList("Les,Josh,Artur,Phil,Julka,Peter".split(","))
                    .forEach(n -> rr.save(new Reservation(n)));

            rr.findAll().forEach(System.out::println);

            rr.findByReservationName("Julka").forEach(System.out::println);
        };
    }
}

@Controller
class ReservationMvcController {
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationMvcController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @RequestMapping("/reservations.php")
    public String reservation(Model model) {
        model.addAttribute("reservations", this.reservationRepository.findAll());

        return "reservations"; // src/main/resources/templates/ + $x + .html
    }
}

@RestController
class ReservationController {
    private ReservationRepository reservationRepository;

    @Autowired
    ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @GetMapping("/reservations")
    Collection<Reservation> reservations() {
        return this.reservationRepository.findAll();
    }


}

interface ReservationRepository extends JpaRepository<Reservation, Long> {
    //select * from reservation where reservationName = :rn
    //    @Query("...")
    Collection<Reservation> findByReservationName(String rn);
}

@Entity
class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    private String reservationName;

    public Reservation() {

    }

    public Reservation(String reservationName) {
        this.reservationName = reservationName;
    }

    public Long getId() {
        return id;
    }

    public String getReservationName() {
        return reservationName;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationName='" + reservationName + '\'' +
                '}';
    }
}