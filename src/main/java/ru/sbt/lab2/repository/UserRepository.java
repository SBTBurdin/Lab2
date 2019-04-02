package ru.sbt.lab2.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sbt.lab2.domain.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Override
    Optional<User> findById(Integer integer);
}
