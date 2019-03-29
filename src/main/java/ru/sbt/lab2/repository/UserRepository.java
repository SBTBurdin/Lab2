package ru.sbt.lab2.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sbt.lab2.domain.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
