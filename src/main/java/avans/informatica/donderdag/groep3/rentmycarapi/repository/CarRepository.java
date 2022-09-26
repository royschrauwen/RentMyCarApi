package avans.informatica.donderdag.groep3.rentmycarapi.repository;

import java.util.List;

import avans.informatica.donderdag.groep3.rentmycarapi.model.Car;
import avans.informatica.donderdag.groep3.rentmycarapi.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByColourContaining(String colour);

    @Query(value = "SELECT * FROM cars WHERE number_of_seats >= ?1", nativeQuery = true)
    List<Car> findSeats(int numberOfSeats);



}
