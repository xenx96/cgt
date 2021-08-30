package com.cgt.cgt_prj.repositories;



import com.cgt.cgt_prj.domain.UserDTO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDTO, Long> {

    //boolean findAllById(String _id);
    //UserDTO save(UserDTO userDTO);
    //Optional<UserDTO> findBy_Id(String _id);
    //Optional<UserDTO> findByEA(String EA);
}
