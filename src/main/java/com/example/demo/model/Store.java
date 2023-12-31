package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int storeId;

    @Column(name = "store_status", length = 15, nullable = false)
    private String storeStatus;

    @Column(name = "user_id", length = 40, nullable = false)
    private String userId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "icon_path", nullable = false, length = 100)
    private String iconPath;

    @Column(name = "store_address", length = 100)
    private String storeAddress;

    @Column(name = "banner_path", length = 50)
    private String bannerPath;

    @Column(name = "story_title", length = 80, nullable = false)
    private String storyTitle;

    @Column(name = "story_description", nullable = false, length = 100)
    private String storyDescription;

    @Column(name = "announcement_title", length = 50)
    private String announcementTitle;

    @Column(name = "announcement_description", length = 100)
    private String announcementDescription;

    @Column(name = "message_to_buyers", length = 100, nullable = false)
    private String messageToBuyers;

    @Column(name = "order_customization_allowed", nullable = false, length = 100)
    private Boolean orderCustomizationAllowed;

    @Column(name = "vacation_mode", nullable = false, length = 100)
    private Boolean vacationMode;

    @Column(name = "vacation_auto_replay", nullable = false, length = 100)
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