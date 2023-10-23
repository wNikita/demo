package com.example.demo.service;

import com.example.demo.dto.StoreDTO;

public interface StoreServiceInterface {

    void createStore(StoreDTO storeDTO);

    StoreDTO getStoreById(Long storeId);

    StoreDTO getStoresByUserId(String userId);


    void updateStore(Long storeId, StoreDTO updatedStoreDTO);
}

