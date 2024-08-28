package com.hancho.management.repository;

import org.springframework.data.repository.CrudRepository;

import com.hancho.management.model.User;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByName(String name);
}
