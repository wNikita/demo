package com.example.demo.controller;

import com.example.demo.Comman.Constant;
import com.example.demo.Comman.ErrorMessage;
import com.example.demo.dto.StoreDTO;
import com.example.demo.exception.ErrorResponse;
import com.example.demo.service.StoreService;
import com.example.demo.validation.StoreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(Constant.BASE_URL)
public class StoreController extends ErrorMessage {

    @Autowired
    private StoreService storeService;

    @Autowired
    private StoreValidator storeValidator;


    @PostMapping
    public void createStore(@RequestBody StoreDTO storeDTO, BindingResult bindingResult) {
        storeValidator.validate(storeDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new ErrorResponse(buildErrorResponse(bindingResult));
        }
        storeService.createStore(storeDTO);
    }

    @PutMapping(Constant.UPDATE_STORE_BY_ID)
    public void updateStore(@PathVariable Long storeId, @RequestBody StoreDTO updatedStore, BindingResult bindingResult) {
        storeValidator.validate(updatedStore, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new ErrorResponse(buildErrorResponse(bindingResult));
        }
        storeService.updateStore(storeId, updatedStore);
    }

    @GetMapping(Constant.GET_STORE_BY_ID)
    public ResponseEntity<StoreDTO> getStoreById(@PathVariable Long storeId) {
        StoreDTO storeDTO = storeService.getStoreById(storeId);
        return ResponseEntity.ok(storeDTO);
    }

    @GetMapping(Constant.GET_STORE_BY_USER_ID)
    public ResponseEntity<List<StoreDTO>> getStoresByUserId(@PathVariable String userId) {
        List<StoreDTO> storeDTO = storeService.getStoresByUserId(userId);
        return ResponseEntity.ok(storeDTO);
    }

    @GetMapping
    public ResponseEntity<List<StoreDTO>> getAllStores() {
        List<StoreDTO> storeDTO = storeService.getAllStore();
        return ResponseEntity.ok(storeDTO);
    }
}
