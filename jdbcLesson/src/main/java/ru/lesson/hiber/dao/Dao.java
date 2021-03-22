package ru.lesson.hiber.dao;

import java.util.List;

public interface Dao<T> {
    void create(T t);

    T read(String model);

    void update(T t);

    void delete(T t);

    List<T> selectStarFromTable();
}
