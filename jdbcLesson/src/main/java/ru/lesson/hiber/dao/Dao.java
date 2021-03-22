package ru.lesson.hiber.dao;

public interface Dao {
    <T> void create(T t);

    <T> T read(String model);

    <T> void update(T t);

    <T> void delete(T t);
}
