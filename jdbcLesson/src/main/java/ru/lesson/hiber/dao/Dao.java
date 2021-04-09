package ru.lesson.hiber.dao;

import ru.lesson.hiber.Cpu;

import java.util.List;

public interface Dao<T> {
    void create(T t);

    T read(T entity);

    T read(int id);

    void update(T t);

    void delete(T t);

    List<T> selectStarFromTable();
}
