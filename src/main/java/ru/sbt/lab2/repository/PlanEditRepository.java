package ru.sbt.lab2.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sbt.lab2.domain.entity.PlanEdit;

public interface PlanEditRepository extends CrudRepository<PlanEdit, Integer> {
}
