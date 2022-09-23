package avans.informatica.donderdag.groep3.rentmycarapi.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "offer")
    private Offer offer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer")
    private User customer;

    public Booking() {
    }

    public Booking(Offer offer, User customer) {
        this.offer = offer;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Booking [" +
                "id=" + id +
                ", offer=" + offer +
                ", customer=" + customer +
                "]";
    }
}
