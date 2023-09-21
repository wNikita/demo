package com.example.demo.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.lang.annotation.Native;

public class StoreDTO {


    private int storeId;
    @NotNull
    @Size(max = 15)
    private String storeStatus;
    @NotNull
    @Size(max = 40)
    private String userId;
    @NotNull
    @Size(max = 50)
    private String name;
    @NotNull
    @Size(max = 50)
    private String email;
    @NotNull
    @Size(max = 50)
    private String title;

    @NotNull
    private String iconPath;
    @NotNull
    private String storeAddress;
    private String bannerPath;
    @NotNull
    @Size(max = 80)
    private String storyTitle;
    @NotNull
    private String storyDescription;
    private String announcementTitle;
    private String announcementDescription;
    @NotNull
    @Size(max = 100)
    private String messageToBuyers;
    @NotNull
    private Boolean orderCustomizationAllowed;
    @NotNull
    private Boolean vacationMode;
    @NotNull
    @Size(max = 100)
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
