package com.example.demo.service;

import com.example.demo.dto.StoreDTO;
import com.example.demo.model.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StoreMapper {

    StoreMapper MAPPER = Mappers.getMapper(StoreMapper.class);

    @Mapping(source = "status", target = "storeStatus")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "iconPath", target = "iconPath")
    @Mapping(source = "storeAddress", target = "storeAddress")
    @Mapping(source = "bannerPath", target = "bannerPath")
    @Mapping(source = "storyTitle", target = "storyTitle")
    @Mapping(source = "storyDescription", target = "storyDescription")
    @Mapping(source = "announcementTitle", target = "announcementTitle")
    @Mapping(source = "announcementDescription", target = "announcementDescription")
    @Mapping(source = "messageToBuyers", target = "messageToBuyers")
    @Mapping(source = "orderCustomizationAllowed", target = "orderCustomizationAllowed")
    @Mapping(source = "vacationMode", target = "vacationMode")
    @Mapping(source = "vacationAutoReply", target = "vacationAutoReply")
    Store storeDTOtoStore(StoreDTO storeDTO);

    @Mapping(source = "storeStatus", target = "status")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "iconPath", target = "iconPath")
    @Mapping(source = "storeAddress", target = "storeAddress")
    @Mapping(source = "bannerPath", target = "bannerPath")
    @Mapping(source = "storyTitle", target = "storyTitle")
    @Mapping(source = "storyDescription", target = "storyDescription")
    @Mapping(source = "announcementTitle", target = "announcementTitle")
    @Mapping(source = "announcementDescription", target = "announcementDescription")
    @Mapping(source = "messageToBuyers", target = "messageToBuyers")
    @Mapping(source = "orderCustomizationAllowed", target = "orderCustomizationAllowed")
    @Mapping(source = "vacationMode", target = "vacationMode")
    @Mapping(source = "vacationAutoReply", target = "vacationAutoReply")
    StoreDTO storeToStoreDTO(Store store);

    @Mapping(source = "status", target = "storeStatus")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "iconPath", target = "iconPath")
    @Mapping(source = "storeAddress", target = "storeAddress")
    @Mapping(source = "bannerPath", target = "bannerPath")
    @Mapping(source = "storyTitle", target = "storyTitle")
    @Mapping(source = "storyDescription", target = "storyDescription")
    @Mapping(source = "announcementTitle", target = "announcementTitle")
    @Mapping(source = "announcementDescription", target = "announcementDescription")
    @Mapping(source = "messageToBuyers", target = "messageToBuyers")
    @Mapping(source = "orderCustomizationAllowed", target = "orderCustomizationAllowed")
    @Mapping(source = "vacationMode", target = "vacationMode")
    @Mapping(source = "vacationAutoReply", target = "vacationAutoReply")
    void entityMapping(StoreDTO storeDTO, @MappingTarget Store store);
}
