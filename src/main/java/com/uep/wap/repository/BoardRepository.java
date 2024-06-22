package com.uep.wap.repository;

import com.uep.wap.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<Board, Integer> {

    Board findByTitle(String title);
    Board findByOwnerID(int OwnerId);

}
