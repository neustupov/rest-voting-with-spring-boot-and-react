package ru.neustupov.restvotingwithspringbootandreact.service;

public interface UserService {

    void enable(String name, boolean enable);

    boolean delete(String name, String email);
}
