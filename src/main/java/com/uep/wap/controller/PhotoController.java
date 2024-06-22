package com.uep.wap.controller;

import com.uep.wap.dto.PhotoDTO;
import com.uep.wap.model.Photo;
import com.uep.wap.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/photos")
public class PhotoController {
    private final PhotoService photoService;

@Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }
    @PostMapping(path="/photos")
    public String addPhoto(@RequestBody PhotoDTO photoDTO) {
        PhotoService.addPhoto(photoDTO);
        return "Photo added successfully";
    }

    @PutMapping(path="/photos/{photo_id}")
    public String editPhoto(@PathVariable  int photo_id, @RequestBody PhotoDTO photoDTO) {
        PhotoService.editPhoto(photo_id, photoDTO);
        return "Photo edited successfully";
    }

    @GetMapping(path="/photos")
    public Iterable<Photo> getAllPhotos() {
        return photoService.getAllPhotos();
    }

    @GetMapping(path="/{id}")
    public Optional<Photo> getPhotoById(@PathVariable int id) {
        return PhotoService.getPhotoById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deletePhotoById(@PathVariable int id) {
        PhotoService.deletePhoto(id);
        return "Photo deleted successfully";
    }
    @GetMapping("/imageURL/{imageURL}")
    public Photo findPhotoByImageURL(@RequestParam String imageURL) {
        return photoService.findPhotoByImageURL(imageURL);
    }
}
