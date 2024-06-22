package com.uep.wap.service;

import com.uep.wap.dto.PhotoDTO;
import com.uep.wap.model.Photo;
import com.uep.wap.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhotoService {
    @Autowired
    private static PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }
    public static Photo addPhoto(PhotoDTO photoDTO) {
        Photo photo = new Photo();
        photo.setImageURL(photoDTO.getImageURL());
        return photoRepository.save(photo);
    }

    public static Photo editPhoto(int photo_id, PhotoDTO photoDTO) {
        Photo photo = photoRepository.findById(photo_id).get();
        photo.setImageURL(photoDTO.getImageURL());
        return photoRepository.save(photo);
    }

    public static Optional<Photo> getPhotoById(int id) {return photoRepository.findById(id);}
    public Iterable<Photo> getAllPhotos() {return photoRepository.findAll();}
    public Photo updatePhoto(int id, PhotoDTO photoDTO) {
        Optional<Photo> existingPhoto = photoRepository.findById(id);
        if (existingPhoto.isPresent()) {
            Photo photo = existingPhoto.get();
            photo.setImageURL(photoDTO.getImageURL());
            return photoRepository.save(photo);
        } else {
            throw new RuntimeException("Photo not found");
        }
    }
    public static void deletePhoto(int id) {photoRepository.deleteById(id);}
    public Photo findPhotoByImageURL(String imageURL) {return photoRepository.findByImageURL(imageURL);}
}

