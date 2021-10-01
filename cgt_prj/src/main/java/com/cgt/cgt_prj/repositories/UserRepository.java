package com.cgt.cgt_prj.repositories;


import com.cgt.cgt_prj.domain.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDTO, String> {

    UserDTO findBy_id(String _id);

    UserDTO findByNN(String NN);

    UserDTO findByEA(String EA);


}
