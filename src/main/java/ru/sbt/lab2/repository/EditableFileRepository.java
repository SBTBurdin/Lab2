package ru.sbt.lab2.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sbt.lab2.domain.entity.EditableFile;

public interface EditableFileRepository extends CrudRepository<EditableFile, Integer> {
}
