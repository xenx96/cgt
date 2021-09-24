package com.cgt.cgt_prj.repositories;



import com.cgt.cgt_prj.domain.UserDTO;

import net.minidev.json.JSONObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserDTO, String> {

    UserDTO findBy_id(String _id);


}
