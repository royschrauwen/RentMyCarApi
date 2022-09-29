package avans.informatica.donderdag.groep3.rentmycarapi.repository;

import java.util.List;

import avans.informatica.donderdag.groep3.rentmycarapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstnameContaining(String name);


}
