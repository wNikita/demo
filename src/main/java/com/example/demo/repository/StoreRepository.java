package com.example.demo.repository;

import com.example.demo.dto.StoreDTO;
import com.example.demo.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    boolean existsByName(String name);
    boolean existsByEmail(String email);
    List<Store> findAllByUserId(String userId);

}

