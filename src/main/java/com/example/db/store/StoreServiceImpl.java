package com.example.db.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public Store save(Store store) {
        return storeRepository.save(store);
    }

    @Override
    @Transactional(readOnly = true)
    public Store update(Long id, Store store) {
        Store store1 = getById(id);
        storeRepository.save(store1);
        return store1;
    }

    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        storeRepository.deleteById(id);
    }

    @Override
    public Store getById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public List<Store> getByContainName(String name) {
        return storeRepository.findByNameContainingOrderByIdDesc(name);
    }
}
