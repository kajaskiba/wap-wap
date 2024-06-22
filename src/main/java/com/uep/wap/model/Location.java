package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int locationID;
    @Column(name = "name")
    private String name;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;

    public Location(){

    }
    @ManyToMany(mappedBy = "locations")
    private List<Photo> photos;

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int location_id) {
        this.locationID = location_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
