package com.example.demo;

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

    @Column(length = 50,nullable = false)
    private String bannerPath;

    @Column(length = 80)
    private String storyTitle;

    @Column(length = 100)
    private String storyDescription;

    @Column(length = 40,nullable = false)
    private String announcementTitle;

    @Column(length = 50,nullable = false)
    private String announcementDescription;

    @Column(length = 100)
    private String messageToBuyers;
    private Boolean orderCustomizationAllowed;
    private Boolean vacationMode;

    @Column(length = 100)
    private String vacationAutoReply;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(String storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public String getStoryDescription() {
        return storyDescription;
    }

    public void setStoryDescription(String storyDescription) {
        this.storyDescription = storyDescription;
    }

    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public String getAnnouncementDescription() {
        return announcementDescription;
    }

    public void setAnnouncementDescription(String announcementDescription) {
        this.announcementDescription = announcementDescription;
    }

    public String getMessageToBuyers() {
        return messageToBuyers;
    }

    public void setMessageToBuyers(String messageToBuyers) {
        this.messageToBuyers = messageToBuyers;
    }

    public Boolean getOrderCustomizationAllowed() {
        return orderCustomizationAllowed;
    }

    public void setOrderCustomizationAllowed(Boolean orderCustomizationAllowed) {
        this.orderCustomizationAllowed = orderCustomizationAllowed;
    }

    public Boolean getVacationMode() {
        return vacationMode;
    }

    public void setVacationMode(Boolean vacationMode) {
        this.vacationMode = vacationMode;
    }

    public String getVacationAutoReply() {
        return vacationAutoReply;
    }

    public void setVacationAutoReply(String vacationAutoReply) {
        this.vacationAutoReply = vacationAutoReply;
    }
}