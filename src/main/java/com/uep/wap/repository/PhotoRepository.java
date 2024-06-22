package com.uep.wap.repository;

import com.uep.wap.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Integer> {

    Photo findByImageURL(String imageURL);
}
