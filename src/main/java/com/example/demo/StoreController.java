package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        Store createdStore = storeService.createStore(store);
        return new ResponseEntity<>(createdStore, HttpStatus.CREATED);
    }

    @PutMapping("/{storeId}")
    public ResponseEntity<Store> updateStore(@PathVariable Long storeId, @RequestBody Store updatedStore) {
        Store store = storeService.updateStore(storeId, updatedStore);
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
        return ResponseEntity.ok(store);
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long storeId) {
        Store store = storeService.getStoreById(storeId);
        return ResponseEntity.ok(store);
    }

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<Store>> getStoresByUserId(@PathVariable String userId) {
        List<Store> stores =  storeService.getStoresByUserId(userId);
        return ResponseEntity.ok(stores);
    }
}
