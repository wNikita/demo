package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StoreRepository extends JpaRepository<Store, Long> {

    // Add custom query methods if needed

    List<Store> findAllByUserId(String userId);

    }



