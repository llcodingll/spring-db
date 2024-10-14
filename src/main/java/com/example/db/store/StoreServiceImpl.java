package com.example.db.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public Store update(Long id, Store store) {
        return null;
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
        return List.of();
    }
}
