package com.example.demo.controller;

import com.example.demo.dto.StoreDTO;
import com.example.demo.exception.ErrorResponse;
import com.example.demo.model.Store;
import com.example.demo.service.StoreService;
import com.example.demo.validation.StoreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private StoreValidator storeValidator;

    @PostMapping("/stores")
    public ResponseEntity<Object> createStore(@RequestBody StoreDTO storeDTO, BindingResult bindingResult) {
        storeValidator.validate(storeDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getFieldErrors().stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .collect(Collectors.toList());
            ErrorResponse errorResponse = new ErrorResponse(errorMessages);

            return ResponseEntity.badRequest().body(errorResponse);
        }
        Store createdStore = storeService.createStore(storeDTO);
        String message = storeService.getStoreCreatedMessage(createdStore.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @GetMapping("/stores")
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @PutMapping("/stores/{storeId}")
    public ResponseEntity<Object> updateStore(@PathVariable Long storeId, @RequestBody StoreDTO updatedStore, BindingResult bindingResult) {
        storeValidator.validate(updatedStore, bindingResult);

        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getFieldErrors().stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errorMessages);
        }
        Store store = storeService.updateStore(storeId, updatedStore);
        return ResponseEntity.ok(store);
    }

    @GetMapping("/stores/{storeId}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long storeId) {

        Store store = storeService.getStoreById(storeId);
        return ResponseEntity.ok(store);
    }


    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Store>> getStoresByUserId(@PathVariable String userId) {
        List<Store> stores = storeService.getStoresByUserId(userId);
        return ResponseEntity.ok(stores);
    }

}
