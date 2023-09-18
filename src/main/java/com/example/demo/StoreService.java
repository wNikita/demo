package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    public Store updateStore(Long storeId, Store updatedStore) {
        Optional<Store> existingStore = storeRepository.findById(storeId);
        if (existingStore.isPresent()) {
            Store store = existingStore.get();
            // Update store attributes based on your requirements
            store.setName(updatedStore.getName());
            store.setUserId(updatedStore.getUserId());
            return storeRepository.save(store);
        } else {
            // Handle the case where the store with the given ID doesn't exist
            return null;
        }
    }

    public Store getStoreById(Long storeId) {
        return storeRepository.findById(storeId).orElse(null);
    }

    public List<Store> getStoresByUserId(String  userId) {
        return storeRepository.findAllByUserId(userId);
    }
}

