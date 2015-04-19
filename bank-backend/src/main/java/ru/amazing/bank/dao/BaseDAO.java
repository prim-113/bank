package ru.amazing.bank.dao;

public interface BaseDAO<T> {

    T get(int id);
    void create(T account);
    void update(T account);
    void delete(int id);
}
