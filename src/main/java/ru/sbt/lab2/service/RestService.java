package ru.sbt.lab2.service;

import ru.sbt.lab2.model.data.DataWrapper;

public interface RestService {

    DataWrapper getUserInfo(Integer id);
}
