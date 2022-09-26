package avans.informatica.donderdag.groep3.rentmycarapi.repository;

import avans.informatica.donderdag.groep3.rentmycarapi.model.Car;
import avans.informatica.donderdag.groep3.rentmycarapi.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findById(int id);

    List<Offer> findByPickupLocation(String pickupLocation);

    @Query(value = "SELECT * FROM offers AS o WHERE o.id NOT IN (SELECT offer FROM bookings)", nativeQuery = true)
    List<Offer> findUnbooked();

}
