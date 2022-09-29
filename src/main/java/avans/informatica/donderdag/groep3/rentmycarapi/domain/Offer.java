package avans.informatica.donderdag.groep3.rentmycarapi.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "startDateTime", columnDefinition = "TIMESTAMP")
    private LocalDateTime startDateTime;

    @Column(name = "endDateTime", columnDefinition = "TIMESTAMP")
    private LocalDateTime endDateTime;

    @Column(name = "pickupLocation")
    private String pickupLocation;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car")
    private Car car;

    public Offer() {
    }

    public Offer(LocalDateTime startDateTime, LocalDateTime endDateTime, String pickupLocation, Car car) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.pickupLocation = pickupLocation;
        this.car = car;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }



    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Offer [" +
                "id=" + id +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", car=" + car +
                "]";
    }
}
