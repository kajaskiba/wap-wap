package com.uep.wap.repository;

import com.uep.wap.model.Interaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteractionRepository extends CrudRepository<Interaction, Integer> {

    Iterable<Interaction> findByType(String type);
    Iterable<Interaction> findByTargetID(int targetID);


}
