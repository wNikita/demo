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


        if (storeDTO.getUserId().length() > 40) {
            errors.rejectValue("userId", "field.too.long");
        }

        if (storeDTO.getName().length() > 50) {
            errors.rejectValue("name", "field.too.long");
        }

        if (storeDTO.getEmail().length() > 50) {
            errors.rejectValue("email", "field.too.long");
        }

        if (storeDTO.getTitle().length() > 50) {
            errors.rejectValue("title", "field.too.long");
        }


        if (storeDTO.getStoryTitle().length() > 80) {
            errors.rejectValue("storyTitle", "field.too.long");
        }

        if (storeDTO.getMessageToBuyers().length() > 100) {
            errors.rejectValue("messageToBuyers", "field.too.long");
        }
    }
}

