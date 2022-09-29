package avans.informatica.donderdag.groep3.rentmycarapi.controller;

import java.util.ArrayList;
import java.util.List;

import avans.informatica.donderdag.groep3.rentmycarapi.domain.Offer;
import avans.informatica.donderdag.groep3.rentmycarapi.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/v1")
public class OfferController {

    @Autowired
    OfferRepository offerRepository;

    @GetMapping("/offers")
    public ResponseEntity<List<Offer>> getAllOffers(@RequestParam(required = false) String pickupLocation) {
        try {
            List<Offer> offers = new ArrayList<>();

            if (pickupLocation == null)
                offerRepository.findAll().forEach(offers::add);
            else
                offerRepository.findByPickupLocation(pickupLocation).forEach(offers::add);

            if (offers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(offers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/offers/unbooked")
    public ResponseEntity<List<Offer>> getAllUnbookedOffers() {
        try {
            List<Offer> offers = new ArrayList<>();

                offerRepository.findUnbooked().forEach(offers::add);

            if (offers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(offers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/offers/booked")
    public ResponseEntity<List<Offer>> getAllBookedOffers() {
        try {
            List<Offer> offers = new ArrayList<>();

            offerRepository.findBooked().forEach(offers::add);

            if (offers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(offers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
