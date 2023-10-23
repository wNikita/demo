package com.example.demo.service;
import com.example.demo.dto.StoreDTO;
import com.example.demo.model.Store;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {
    private final ModelMapper modelMapper;

    public StoreMapper() {
        modelMapper = new ModelMapper();

    }

    public StoreDTO mapToStoreDTO(Store store) {
        return modelMapper.map(store, StoreDTO.class);
    }
    public Store mapToStore(StoreDTO storeDTO) {
        return modelMapper.map(storeDTO, Store.class);
    }

    public void mapToEntity(StoreDTO storeDTO, Store store) {
        modelMapper.map(storeDTO, store);
    }

}
