package avans.informatica.donderdag.groep3.rentmycarapi.repository;

import java.util.List;

import avans.informatica.donderdag.groep3.rentmycarapi.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findById(int id);

}
