package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int storeId;

    @Column(length = 15)
    private String storeStatus;

    @Column(length = 40)
    private String userId;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String email;

    @Column(length = 50)
    private String title;

    @Column(length = 50)
    private String iconPath;

    @Column(length = 50)
    private String storeAddress;

    @Column(length = 50, nullable = false)
    private String bannerPath;

    @Column(length = 80)
    private String storyTitle;

    @Column(length = 100)
    private String storyDescription;

    @Column(length = 40, nullable = false)
    private String announcementTitle;

    @Column(length = 50, nullable = false)
    private String announcementDescription;

    @Column(length = 100)
    private String messageToBuyers;
    private Boolean orderCustomizationAllowed;
    private Boolean vacationMode;

    @Column(length = 100)
    private String vacationAutoReply;

}