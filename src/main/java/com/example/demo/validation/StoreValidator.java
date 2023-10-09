package com.example.demo.validation;

import com.example.demo.dto.StoreDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class StoreValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return StoreDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        StoreDTO storeDTO = (StoreDTO) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storeStatus", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "iconPath", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storeAddress", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storyTitle", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storyDescription", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messageToBuyers", "required.field");


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storeStatus", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "iconPath", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storeAddress", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storyTitle", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storyDescription", "required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messageToBuyers", "required.field");

        if (storeDTO.getStoreStatus() != null && storeDTO.getStoreStatus().length() > 15) {
            errors.rejectValue("storeStatus", "field.toolong");
        }

        if (storeDTO.getUserId() != null && storeDTO.getUserId().length() > 40) {
            errors.rejectValue("userId", "field.toolong");
        }

        if (storeDTO.getName() != null && storeDTO.getName().length() > 50) {
            errors.rejectValue("name", "field.toolong");
        }

        if (storeDTO.getEmail() != null && storeDTO.getEmail().length() > 50) {
            errors.rejectValue("email", "field.toolong");
        }

        if (storeDTO.getTitle() != null && storeDTO.getTitle().length() > 50) {
            errors.rejectValue("title", "field.toolong");
        }

        if (storeDTO.getIconPath() != null && storeDTO.getIconPath().length() > 255) {
            errors.rejectValue("iconPath", "field.toolong");
        }

        if (storeDTO.getStoreAddress() != null && storeDTO.getStoreAddress().length() > 255) {
            errors.rejectValue("storeAddress", "field.toolong");
        }

        if (storeDTO.getStoryTitle() != null && storeDTO.getStoryTitle().length() > 80) {
            errors.rejectValue("storyTitle", "field.toolong");
        }

        if (storeDTO.getMessageToBuyers() != null && storeDTO.getMessageToBuyers().length() > 100) {
            errors.rejectValue("messageToBuyers", "field.toolong");
        }
    }
}

