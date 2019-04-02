package ru.sbt.lab2.model.data;

import com.fasterxml.jackson.annotation.JsonView;

public class DataWrapper<T> {
    private T data;

    public DataWrapper(T data) {
        this.data = data;
    }

    @JsonView
    public T getData() {
        return data;
    }
}
