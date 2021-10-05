package com.cgt.cgt_prj.repositories;


import com.cgt.cgt_prj.domain.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserDTO, String> {

<<<<<<< HEAD
    Optional<UserDTO> findByID(String _id);
=======
    UserDTO findBy_id(String _id);
>>>>>>> parent of 502b57c (_id를 ID로 변환)

    UserDTO findByNN(String NN);

    UserDTO findByEA(String EA);


}
