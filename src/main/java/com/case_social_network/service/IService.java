package com.case_social_network.service;

import java.util.List;

public interface IService<E> {
    List<E> getAll();
    E save(E e);
    void delete(long id);
    E findById(long id);
    List<E> findByStr(String name);

}
