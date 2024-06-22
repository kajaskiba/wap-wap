package com.uep.wap.service;

import com.uep.wap.dto.CategoryDTO;
import com.uep.wap.dto.LocationDTO;
import com.uep.wap.model.Category;
import com.uep.wap.model.Location;
import com.uep.wap.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private  LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location addLocation(LocationDTO locationDTO) {
        Location location = new Location();
        location.setName(locationDTO.getName());
        location.setLatitude(locationDTO.getLatitude());
        location.setLongitude(locationDTO.getLongitude());
        return locationRepository.save(location);
    }

    public Location editLocation(int location_id, LocationDTO locationDTO) {
        Location location = locationRepository.findById(location_id).get();
        location.setName(locationDTO.getName());
        location.setLatitude(locationDTO.getLatitude());
        location.setLongitude(locationDTO.getLongitude());
        return locationRepository.save(location);
    }

    public Iterable<Location> getAllLocations() {return locationRepository.findAll();}
    public Optional<Location> getLocationById(int id) {return locationRepository.findById(id);}
    public void deleteLocation(int id) {locationRepository.deleteById(id);}
    public Location findLocationByName(String name) {return locationRepository.findByName(name);}
}
