package avans.informatica.donderdag.groep3.rentmycarapi.repository;

import java.util.List;

import avans.informatica.donderdag.groep3.rentmycarapi.domain.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);
}
