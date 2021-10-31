package com.cgt.cgt_prj.repositories;

import com.cgt.cgt_prj.domain.Email;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;

@Repository
public interface EmailRepository extends MongoRepository<Email, Long> {
    Email findOne(Email email);
    List<HashMap> findEmailsByIp(String ip);

}
