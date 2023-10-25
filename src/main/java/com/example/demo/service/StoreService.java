package com.example.demo.service;

import com.example.demo.dto.StoreDTO;
import com.example.demo.exception.DuplicateKeyException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Store;
import com.example.demo.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoreService implements StoreServiceInterface {
    private final StoreRepository storeRepository;

    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public void createStore(StoreDTO storeDTO) {
        if (storeRepository.existsByName(storeDTO.getName())) {
            throw new DuplicateKeyException("Name already exists.");
        }
        if (storeRepository.existsByEmail(storeDTO.getEmail())) {
            throw new DuplicateKeyException("Email already exists.");
        }
        if (storeRepository.existsByUserId(storeDTO.getUserId())) {
            throw new DuplicateKeyException("You can have only one store per user");
        }
        Store store = storeMapper.mapToStore(storeDTO);
        storeRepository.save(store);
    }

    @Override
    public StoreDTO getStoreById(Long storeId) {
        Optional<Store> storeOptional = storeRepository.findByStoreId(storeId);
        if (storeOptional.isEmpty()) {
            throw new ResourceNotFoundException("Store with ID " + storeId + " not found");
        }
        return storeMapper.mapToStoreDTO(storeOptional.get());
    }

    @Override
    public void updateStore(Long storeId, StoreDTO updatedStoreDTO) {
        Optional<Store> storeOptional = storeRepository.findById(storeId);
        if (storeOptional.isEmpty()) {
            throw new ResourceNotFoundException("Store with ID " + storeId + " not found");
        }
        Store store = storeOptional.get();
        storeMapper.mapToEntity(updatedStoreDTO, store);
        if (storeRepository.existsByName(updatedStoreDTO.getName())) {
            throw new DuplicateKeyException("Name already exists.");
        }
        if (storeRepository.existsByEmail(updatedStoreDTO.getEmail())) {
            throw new DuplicateKeyException("Email already exists.");
        }
        storeRepository.save(store);

    }

    @Override
    public StoreDTO getStoresByUserId(String userId) {
        Optional<Store> stores = storeRepository.findByUserId(userId);
        if (stores.isEmpty()) {
            throw new ResourceNotFoundException("No stores found for user with ID: " + userId);
        }
        return storeMapper.mapToStoreDTO(stores.get());
    }

    @Override
    public List<StoreDTO> getAllStore() {
        List<Store> stores = storeRepository.findAll();
        if (stores.isEmpty()) {
            throw new ResourceNotFoundException("No stores are currently available");
        }
        return stores.stream().map(storeMapper::mapToStoreDTO).collect(Collectors.toList());

    }

}

