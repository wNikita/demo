package com.example.demo.controller;

import com.example.demo.dto.StoreDTO;
import com.example.demo.exception.ErrorResponse;
import com.example.demo.model.Store;
import com.example.demo.service.StoreMapper;
import com.example.demo.service.StoreService;
import com.example.demo.validation.StoreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
    private MessageSource messageSource;

    @Autowired
    private StoreValidator storeValidator;

    @Autowired
    private StoreMapper storeMapper;

    @PostMapping("/stores")
    public ResponseEntity<Object> createStore(@RequestBody StoreDTO storeDTO, BindingResult bindingResult) {
        storeValidator.validate(storeDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getFieldErrors().stream()
                    .map(fieldError -> fieldError.getField() + " "
                            + messageSource.getMessage(fieldError, LocaleContextHolder.getLocale())).
                    collect(Collectors.toList());
            ErrorResponse response = new ErrorResponse(errorMessages);
            return ResponseEntity.badRequest().body(response);
        }
        storeService.createStore(storeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(HttpStatus.OK);
    }

    @PutMapping("/stores/{storeId}")
    public ResponseEntity<Object> updateStore(@PathVariable Long storeId, @RequestBody StoreDTO updatedStore, BindingResult bindingResult) {
        storeValidator.validate(updatedStore, bindingResult);
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getFieldErrors().stream()
                    .map(fieldError -> fieldError.getField() + " "
                            + messageSource.getMessage(fieldError, LocaleContextHolder.getLocale())).
                    collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errorMessages);
        }
        storeService.updateStore(storeId, updatedStore);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/stores/{storeId}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long storeId) {
        StoreDTO storeDTO = storeService.getStoreById(storeId);
        Store store = storeMapper.mapToStore(storeDTO);
        return ResponseEntity.ok(store);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Store>> getStoresByUserId(@PathVariable String userId) {
        List<StoreDTO> storeDTO = storeService.getStoresByUserId(userId);
        List<Store> store = storeDTO.stream().map(storeMapper::mapToStore).collect(Collectors.toList());
        return ResponseEntity.ok(store);
    }

    @GetMapping("/stores")
    public ResponseEntity<List<Store>> getAllStores() {
        List<StoreDTO> storeDTOs = storeService.getAllStore();
        List<Store> stores = storeDTOs.stream().map(storeMapper::mapToStore).collect(Collectors.toList());
        return ResponseEntity.ok(stores);
    }
}
