package com.cgt.cgt_prj.repositories;

import com.cgt.cgt_prj.domain.Board;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends MongoRepository<Board, String> {

}
