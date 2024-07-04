package com.harsh.jwtAuthProject.repositories;

import com.harsh.jwtAuthProject.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
