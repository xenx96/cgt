package com.cgt.cgt_prj.repositories;


import com.cgt.cgt_prj.domain.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserDTO, String> {

    Optional<UserDTO> findByID(String _id);

    UserDTO findByNN(String NN);

    UserDTO findByEA(String EA);

    void deleteByID(String id);
}
