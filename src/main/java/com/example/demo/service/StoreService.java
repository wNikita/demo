package com.example.demo.service;

import com.example.demo.Comman.Message;
import com.example.demo.dto.StoreDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Store;
import com.example.demo.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.Comman.MessageKeys.*;

@Service
public class StoreService implements StoreServiceInterface {
    private final StoreRepository storeRepository;


    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public void createStore(StoreDTO storeDTO) {
        Store store = StoreMapper.MAPPER.storeDTOtoStore(storeDTO);
        storeRepository.save(store);
    }

    @Override
    public StoreDTO getStoreById(Long storeId) {
        Optional<Store> storeOptional = storeRepository.findByStoreId(storeId);
        if (storeOptional.isEmpty()) {
            throw new ResourceNotFoundException(Message.get(STORE_NOT_FOUND));
        }
        return StoreMapper.MAPPER.storeToStoreDTO(storeOptional.get());
    }

    @Override
    public void updateStore(Long storeId, StoreDTO updatedStoreDTO) {
        Optional<Store> storeOptional = storeRepository.findById(storeId);
        if (storeOptional.isEmpty()) {
            throw new ResourceNotFoundException(Message.get(STORE_NOT_FOUND));
        }
        Store store = storeOptional.get();
        StoreMapper.MAPPER.entityMapping(updatedStoreDTO, store);
        storeRepository.save(store);

    }

    @Override
    public List<StoreDTO> getStoresByUserId(String userId) {
        List<Store> stores = storeRepository.findByUserId(userId);
        if (stores.isEmpty()) {
            throw new ResourceNotFoundException(Message.get(USER_NOT_FOUND));
        }
        return stores.stream().map(StoreMapper.MAPPER::storeToStoreDTO).collect(Collectors.toList());

    }

    @Override
    public List<StoreDTO> getAllStore() {
        List<Store> stores = storeRepository.findAll();
        if (stores.isEmpty()) {
            throw new ResourceNotFoundException(Message.get(NO_STORE_AVAILABLE));
        }
        return stores.stream().map(StoreMapper.MAPPER::storeToStoreDTO).collect(Collectors.toList());

    }

}

