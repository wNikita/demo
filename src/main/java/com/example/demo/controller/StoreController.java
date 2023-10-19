package com.example.demo.controller;

import com.example.demo.dto.StoreDTO;
import com.example.demo.exception.ErrorResponse;
import com.example.demo.model.Store;
import com.example.demo.service.StoreService;
import com.example.demo.validation.StoreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private StoreValidator storeValidator;

    @PostMapping("/stores")
    public ResponseEntity<Object> createStore(@RequestBody StoreDTO storeDTO, BindingResult bindingResult) {
        storeValidator.validate(storeDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getFieldErrors().stream().map
                    (fieldError -> fieldError.getField() + " " + messageSource.getMessage
                            (fieldError, LocaleContextHolder.getLocale())).collect(Collectors.toList());
            ErrorResponse response = new ErrorResponse(errorMessages);
            return ResponseEntity.badRequest().body(response);
        }
        Store createdStore = storeService.createStore(storeDTO);
        String message = storeService.getStoreCreatedMessage(createdStore.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @GetMapping("/stores")
    public ResponseEntity<List<StoreDTO>> getAllStores() {
        List<Store> stores = storeService.getAllStores();
        List<StoreDTO> storeDTOs = new ArrayList<>();
        for (Store store : stores) {
            storeDTOs.add(StoreDTO.fromStore(store));
        }
        return ResponseEntity.ok(storeDTOs);
    }

    @PutMapping("/stores/{storeId}")
    public ResponseEntity<Object> updateStore(@PathVariable Long storeId, @RequestBody StoreDTO updatedStore, BindingResult bindingResult) {
        storeValidator.validate(updatedStore, bindingResult);
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getFieldErrors().stream().map(fieldError ->
                            fieldError.getField()
                                    + " " + messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()))
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errorMessages);
        }
        Store store = storeService.updateStore(storeId, updatedStore);
        return ResponseEntity.ok(store);
    }

    @GetMapping("/stores/{storeId}")
    public ResponseEntity<StoreDTO> getStoreById(@PathVariable Long storeId) {
        Store store = storeService.getStoreById(storeId);
        StoreDTO storeDTO = StoreDTO.fromStore(store);
        return ResponseEntity.ok(storeDTO);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<StoreDTO>> getStoresByUserId(@PathVariable String userId) {
        List<Store> stores = storeService.getStoresByUserId(userId);
        List<StoreDTO> storeDTOs = new ArrayList<>();
        for (Store store : stores) {
            storeDTOs.add(StoreDTO.fromStore(store));
        }
        return ResponseEntity.ok(storeDTOs);
    }

    @DeleteMapping("/stores/{id}")
    public ResponseEntity<Object> deleteStore(@PathVariable Long id) {
        Store store = storeService.getStoreById(id);
        storeService.deleteStoreById(id);
        String message = storeService.getStoreDeletedMessage(store.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(message);

    }

}
