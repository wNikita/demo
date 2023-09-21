package com.example.demo.service;



import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Store;
import com.example.demo.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

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

    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    public Store updateStore(Long storeId, Store updatedStore) {
        Optional<Store> existingStore = storeRepository.findById(storeId);
        if (existingStore.isPresent()) {
            Store store = existingStore.get();
            // Update store attributes based on your requirements
            store.setStoreStatus(updatedStore.getStoreStatus());
            store.setName(updatedStore.getName());
            store.setEmail(updatedStore.getEmail());
            store.setTitle(updatedStore.getTitle());
            store.setIconPath(updatedStore.getIconPath());
            store.setStoreAddress(updatedStore.getStoreAddress());
            store.setBannerPath(updatedStore.getBannerPath());
            store.setStoryTitle(updatedStore.getStoryTitle());
            store.setStoryDescription(updatedStore.getStoryDescription());
            store.setAnnouncementTitle(updatedStore.getAnnouncementTitle());
            store.setAnnouncementDescription(updatedStore.getAnnouncementDescription());
            store.setMessageToBuyers(updatedStore.getMessageToBuyers());
            store.setOrderCustomizationAllowed(updatedStore.getOrderCustomizationAllowed());
            store.setVacationMode(updatedStore.getVacationMode());
            store.setVacationAutoReply(updatedStore.getVacationAutoReply());
            return storeRepository.save(store);
        } else {
            // Handle the case where the store with the given ID doesn't exist
            return null;
        }
    }
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }
    public Store getStoreById(Long storeId) {
        return storeRepository.findById(storeId).
         orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + storeId));

    }

    public List<Store> getStoresByUserId(String  userId) {
        return storeRepository.findAllByUserId(userId);
    }

}

