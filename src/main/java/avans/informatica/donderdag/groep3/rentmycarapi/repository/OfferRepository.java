package avans.informatica.donderdag.groep3.rentmycarapi.repository;

import avans.informatica.donderdag.groep3.rentmycarapi.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findById(int id);

    List<Offer> findByPickupLocation(String pickupLocation);

}
