package com.example.demo.dto;


import jakarta.validation.constraints.NotNull;

import java.lang.annotation.Native;

public class StoreDTO {


    private int storeId;
    @NotNull
    private String storeStatus;
    @NotNull
    private String userId;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String title;
    @NotNull

    private String iconPath;
    @NotNull
    private String storeAddress;
    private String bannerPath;
    @NotNull
    private String storyTitle;
    @NotNull
    private String storyDescription;
    private String announcementTitle;
    private String announcementDescription;
    @NotNull
    private String messageToBuyers;
    @NotNull
    private Boolean orderCustomizationAllowed;
    @NotNull
    private Boolean vacationMode;
    @NotNull
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
