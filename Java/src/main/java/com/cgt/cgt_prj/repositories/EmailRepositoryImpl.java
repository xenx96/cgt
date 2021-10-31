package com.cgt.cgt_prj.repositories;

import com.cgt.cgt_prj.domain.Email;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class EmailRepositoryImpl implements EmailRepository {
    @Override
    public Email findOne(Email email) {
        return null;
    }

    @Override
    public List<HashMap> findEmailsByIp(String ip) {
        return findAll({ip : ip});
    }

    @Override
    public <S extends Email> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Email> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Email> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Email> findAll() {
        return null;
    }

    @Override
    public Iterable<Email> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Email entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Email> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Email> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Email> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Email> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Email> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Email> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Email> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Email> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Email> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Email> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Email> boolean exists(Example<S> example) {
        return false;
    }
}
