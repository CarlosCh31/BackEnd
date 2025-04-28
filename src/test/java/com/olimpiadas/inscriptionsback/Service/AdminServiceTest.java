package com.olimpiadas.inscriptionsback.Service;

import com.olimpiadas.inscriptionsback.Models.Administrator;
import com.olimpiadas.inscriptionsback.Repositories.AdminRepository;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class AdminServiceTest {


    private final AdminService adminService = new AdminService(new AdminRepository() {
        @Override
        public String actualizarAdministrador(String email, String password) {
            return "";
        }

        @Override
        public String deleteAdministrador(String email) {
            return "";
        }

        @Override
        public Optional<Administrator> findByEmail(String email) {
            return Optional.empty();
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Administrator> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Administrator> List<S> saveAllAndFlush(Iterable<S> entities) {
            return List.of();
        }

        @Override
        public void deleteAllInBatch(Iterable<Administrator> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Integer> integers) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Administrator getOne(Integer integer) {
            return null;
        }

        @Override
        public Administrator getById(Integer integer) {
            return null;
        }

        @Override
        public Administrator getReferenceById(Integer integer) {
            return null;
        }

        @Override
        public <S extends Administrator> List<S> findAll(Example<S> example) {
            return List.of();
        }

        @Override
        public <S extends Administrator> List<S> findAll(Example<S> example, Sort sort) {
            return List.of();
        }

        @Override
        public <S extends Administrator> List<S> saveAll(Iterable<S> entities) {
            return List.of();
        }

        @Override
        public List<Administrator> findAll() {
            return List.of();
        }

        @Override
        public List<Administrator> findAllById(Iterable<Integer> integers) {
            return List.of();
        }

        @Override
        public <S extends Administrator> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Administrator> findById(Integer integer) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Integer integer) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Integer integer) {

        }

        @Override
        public void delete(Administrator entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Integer> integers) {

        }

        @Override
        public void deleteAll(Iterable<? extends Administrator> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public List<Administrator> findAll(Sort sort) {
            return List.of();
        }

        @Override
        public Page<Administrator> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Administrator> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Administrator> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Administrator> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Administrator> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Administrator, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    });

    @Test
    void save() {
        Administrator adminTemp = new Administrator(0L, "email", "pass", null);
        assertNull(adminService.save(adminTemp));
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByIdAndPassword() {
    }

    @Test
    void actualizarAdministrador() {
    }
}