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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storeStatus", "required.field", "Store status is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required.field", "User ID is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.field", "Name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.field", "Email is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required.field", "Title is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "iconPath", "required.field", "Icon path is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storeAddress", "required.field", "Store address is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storyTitle", "required.field", "Story title is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storyDescription", "required.field", "Story description is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messageToBuyers", "required.field", "Message to buyers is required.");

        if (storeDTO.getStoreStatus() != null && storeDTO.getStoreStatus().length() > 15) {
            errors.rejectValue("storeStatus", "field.toolong", "Store status must not exceed 15 characters.");
        }

        if (storeDTO.getUserId() != null && storeDTO.getUserId().length() > 40) {
            errors.rejectValue("userId", "field.toolong", "User ID must not exceed 40 characters.");
        }

        if (storeDTO.getName() != null && storeDTO.getName().length() > 50) {
            errors.rejectValue("name", "field.toolong", "Name must not exceed 50 characters.");
        }

        if (storeDTO.getEmail() != null && storeDTO.getEmail().length() > 50) {
            errors.rejectValue("email", "field.toolong", "Email must not exceed 50 characters.");
        }

        if (storeDTO.getTitle() != null && storeDTO.getTitle().length() > 50) {
            errors.rejectValue("title", "field.toolong", "Title must not exceed 50 characters.");
        }

        if (storeDTO.getIconPath() != null && storeDTO.getIconPath().length() > 255) {
            errors.rejectValue("iconPath", "field.toolong", "Icon path must not exceed 255 characters.");
        }

        if (storeDTO.getStoreAddress() != null && storeDTO.getStoreAddress().length() > 255) {
            errors.rejectValue("storeAddress", "field.toolong", "Store address must not exceed 255 characters.");
        }

        if (storeDTO.getStoryTitle() != null && storeDTO.getStoryTitle().length() > 80) {
            errors.rejectValue("storyTitle", "field.toolong", "Story title must not exceed 80 characters.");
        }

        if (storeDTO.getMessageToBuyers() != null && storeDTO.getMessageToBuyers().length() > 100) {
            errors.rejectValue("messageToBuyers", "field.toolong", "Message to buyers must not exceed 100 characters.");
        }
    }
}

