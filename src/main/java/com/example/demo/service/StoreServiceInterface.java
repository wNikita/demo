package com.example.demo.service;

import com.example.demo.dto.StoreDTO;

import java.util.List;

public interface StoreServiceInterface {

    void createStore(StoreDTO storeDTO);

    List<StoreDTO> getAllStore();

    StoreDTO getStoreById(Long storeId);

    List<StoreDTO> getStoresByUserId(String userId);


    void updateStore(Long storeId, StoreDTO updatedStoreDTO);
}

