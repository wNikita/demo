


package com.example.demo.controller;


import com.example.demo.model.Store;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.StoreService;
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

    @PostMapping("/create")
    public ResponseEntity<String> createStore(@RequestBody Store store) {
        Store createdStore = storeService.createStore(store);
        String message = storeService.getStoreCreatedMessage(createdStore.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @PutMapping("/{storeId}")
    public ResponseEntity<Store> updateStore(@PathVariable Long storeId, @RequestBody Store updatedStore) {
        Store store = storeService.updateStore(storeId, updatedStore);
        return ResponseEntity.ok(store);
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long storeId) {

        Store store = storeService.getStoreById(storeId);
        return ResponseEntity.ok(store);
    }


    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<Store>> getStoresByUserId(@PathVariable String userId) {
        List<Store> stores = storeService.getStoresByUserId(userId);
        return ResponseEntity.ok(stores);
    }
}
