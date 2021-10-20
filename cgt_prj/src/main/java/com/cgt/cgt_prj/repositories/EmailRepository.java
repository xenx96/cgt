package com.cgt.cgt_prj.repositories;

import com.cgt.cgt_prj.domain.Email;
import java.util.HashMap;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends MongoRepository<Email, Long> {
    Email findOne(Email email);
    List<Email> findEmailsByIp();

}
