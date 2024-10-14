package com.example.db.store;

import java.util.List;

public interface StoreService {

    Store save(Store store);
    Store update(Long id, Store store);
    Store getById(Long id);
    List<Store> getByContainName(String name);
    List<Store> getAll();
    void deleteById(Long id);

}
