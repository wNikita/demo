package com.example.demo.service;

import com.example.demo.dto.StoreDTO;
import com.example.demo.exception.DuplicateNameException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Store;
import com.example.demo.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class StoreService {
    private final StoreRepository storeRepository;
    @Autowired
    private MessageSource messageSource;

    public String getStoreCreatedMessage(String storeName) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("store.created", new Object[]{storeName}, locale);
    }

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Store createStore(StoreDTO storeDTO) {
        Store store = new Store();
        if (storeRepository.existsByName(storeDTO.getName())) {
            throw new DuplicateNameException("Name already exists.");
        }

        if (storeRepository.existsByEmail(storeDTO.getEmail())) {
            throw new DuplicateNameException("Email already exists.");
        }

        store.setStoreStatus(storeDTO.getStoreStatus());
        store.setName(storeDTO.getName());
        store.setEmail(storeDTO.getEmail());
        store.setUserId(storeDTO.getUserId());
        store.setTitle(storeDTO.getTitle());
        store.setIconPath(storeDTO.getIconPath());
        store.setStoreAddress(storeDTO.getStoreAddress());
        store.setBannerPath(storeDTO.getBannerPath());
        store.setStoryTitle(storeDTO.getStoryTitle());
        store.setStoryDescription(storeDTO.getStoryDescription());
        store.setAnnouncementTitle(storeDTO.getAnnouncementTitle());
        store.setAnnouncementDescription(storeDTO.getAnnouncementDescription());
        store.setMessageToBuyers(storeDTO.getMessageToBuyers());
        store.setOrderCustomizationAllowed(storeDTO.getOrderCustomizationAllowed());
        store.setVacationMode(storeDTO.getVacationMode());
        store.setVacationAutoReply(storeDTO.getVacationAutoReply());
        return storeRepository.save(store);
    }

    public Store updateStore(Long storeId, StoreDTO updatedStore) {
        Optional<Store> existingStore = storeRepository.findById(storeId);
        if (!existingStore.isPresent()) {
            throw new ResourceNotFoundException("No store found with id: " + storeId);
        }
        Store store = existingStore.get();
        store.setStoreStatus(updatedStore.getStoreStatus());
        store.setName(updatedStore.getName());
        store.setEmail(updatedStore.getEmail());
        store.setTitle(updatedStore.getTitle());
        store.setIconPath(updatedStore.getIconPath());

        store.setOrderCustomizationAllowed(updatedStore.getOrderCustomizationAllowed());
        store.setVacationMode(updatedStore.getVacationMode());
        store.setVacationAutoReply(updatedStore.getVacationAutoReply());

        return storeRepository.save(store);
    }


    public List<Store> getAllStores() {
        List<Store> stores = storeRepository.findAll();

        if (stores.isEmpty()) {
            throw new ResourceNotFoundException("No stores are currently available");
        }
        return storeRepository.findAll();
    }

    public Store getStoreById(Long storeId) {
        return storeRepository.findById(storeId).orElseThrow(() ->
                new ResourceNotFoundException("Store not found with id :" + storeId));

    }

    public List<Store> getStoresByUserId(String userId) {
        List<Store> stores = storeRepository.findAllByUserId(userId);
        if (stores.isEmpty()) {
            throw new ResourceNotFoundException("No stores found for user with ID: " + userId);
        }
        return stores;
    }

    public Store deleteStoreById(Long id) {
        Store store = storeRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Store not found with id:" + id));
        storeRepository.deleteById(id);
        return store;
    }

    public String getStoreDeletedMessage(String storeName) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("store.deleted", new Object[]{storeName}, locale);
    }

}

