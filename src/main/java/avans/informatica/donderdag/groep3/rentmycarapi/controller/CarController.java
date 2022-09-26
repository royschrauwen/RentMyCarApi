package avans.informatica.donderdag.groep3.rentmycarapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import avans.informatica.donderdag.groep3.rentmycarapi.model.Car;
import avans.informatica.donderdag.groep3.rentmycarapi.model.Tutorial;
import avans.informatica.donderdag.groep3.rentmycarapi.repository.CarRepository;
import avans.informatica.donderdag.groep3.rentmycarapi.repository.TutorialRepository;
import avans.informatica.donderdag.groep3.rentmycarapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/v1")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars(@RequestParam(required = false) String colour) {
        try {
            List<Car> cars = new ArrayList<>();

            if (colour == null)
                carRepository.findAll().forEach(cars::add);
            else
                carRepository.findByColourContaining(colour).forEach(cars::add);

            if (cars.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cars, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/cars")
//    public ResponseEntity<List<Car>> getAllCarsWithSeats(int seats) {
//        try {
//            List<Car> cars = new ArrayList<>();
//                carRepository.findBySeats(seats).forEach(cars::add);
//
//            if (cars.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(cars, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }



    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") long id) {
        Optional<Car> carData = carRepository.findById(id);

        if (carData.isPresent()) {
            return new ResponseEntity<>(carData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
