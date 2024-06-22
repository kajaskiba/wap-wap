package com.uep.wap.controller;

import com.uep.wap.dto.CategoryDTO;
import com.uep.wap.dto.LocationDTO;
import com.uep.wap.model.Location;
import com.uep.wap.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping(path="/locations")
    public String addLocation(@RequestBody LocationDTO locationDTO) {
        locationService.addLocation(locationDTO);
        return "Location added successfully";
    }

    @PutMapping(path="/locations/{location_id}")
    public String editLocation(@PathVariable  int location_id, @RequestBody LocationDTO locationDTO) {
        locationService.editLocation(location_id, locationDTO);
        return "Location edited successfully";
    }

    @GetMapping(path="/locations")
    public Iterable<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping(path="/{id}")
    public Optional<Location> getLocationById(@PathVariable int id) {
        return locationService.getLocationById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteLocationById(@PathVariable int id) {
        locationService.deleteLocation(id);
        return "Location deleted successfully";
    }

    @GetMapping(path="/name/{name}")
    public Location findLocationByName(@PathVariable String name) {
        return locationService.findLocationByName(name);
    }
}
