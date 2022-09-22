package avans.informatica.donderdag.groep3.rentmycarapi.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "numberplate")
    private String numberplate;

    @Column(name = "numberOfSeats")
    private int numberOfSeats;

    @Column(name = "colour")
    private String colour;



    @Column(name = "year")
    private int year;

    @Column(name = "fuel")
    private int fuel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ownerId")
    private User owner;

    public Car() {
    }

    public Car(String numberplate, int numberOfSeats, String colour, int year, int fuel, User user) {
        this.numberplate = numberplate;
        this.numberOfSeats = numberOfSeats;
        this.colour = colour;
        this.year = year;
        this.fuel = fuel;
        this.owner = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
}
