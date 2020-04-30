package com.example.cruiseship28420.beans;
import javax.persistence.*;

@Entity
@Table(name = "cruiseShips")
public class CruiseShip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int numberOfPools;
    @Column
    private int numberOfRooms;

    public CruiseShip(String name, int numberOfPools, int numberOfRooms) {
        this.name = name;
        this.numberOfPools = numberOfPools;
        this.numberOfRooms = numberOfRooms;
    }
    public CruiseShip() { }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPools() {
        return numberOfPools;
    }

    public void setNumberOfPools(int numberOfPools) {
        this.numberOfPools = numberOfPools;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

}
