package avans.informatica.donderdag.groep3.rentmycarapi.repository;

import java.util.List;

import avans.informatica.donderdag.groep3.rentmycarapi.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByColourContaining(String colour);

}
