package com.example.demo.validation;

import com.example.demo.dto.StoreDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        if (!isValidEmail(storeDTO.getEmail())) {
            errors.rejectValue("email", "field.invalidEmail");
        }
        if (storeDTO.getStoreStatus() != null && storeDTO.getStoreStatus().length() > 15) {
            errors.rejectValue("storeStatus", "field.too.long");
        }

        if (storeDTO.getName() != null && storeDTO.getName().length() > 50) {
            errors.rejectValue("name", "field.too.long");
        }

        if (storeDTO.getEmail() != null && storeDTO.getEmail().length() > 50) {
            errors.rejectValue("email", "field.too.long");
        }

        if (storeDTO.getTitle() != null && storeDTO.getTitle().length() > 80) {
            errors.rejectValue("title", "field.too.long");
        }

        if (storeDTO.getStoryTitle() != null && storeDTO.getStoryTitle().length() > 80) {
            errors.rejectValue("storyTitle", "field.too.long");
        }
        if (storeDTO.getAnnouncementTitle() != null && storeDTO.getStoryTitle().length() > 100) {
            errors.rejectValue("announcementTitle", "field.too.long");
        }

        if (storeDTO.getMessageToBuyers() != null && storeDTO.getMessageToBuyers().length() > 100) {
            errors.rejectValue("messageToBuyers", "field.too.long");
        }
    }
//        validateFieldLength(storeDTO.getStoreStatus(), "storeStatus", 15, errors);
//        validateFieldLength(storeDTO.getName(), "name", 50, errors);
//        validateFieldLength(storeDTO.getTitle(), "title", 100, errors);
//        validateFieldLength(storeDTO.getEmail(), "email", 50, errors);
//        validateFieldLength(storeDTO.getStoryTitle(), "storyTitle", 80, errors);
//        validateFieldLength(storeDTO.getAnnouncementTitle(), "announcementTitle", 50, errors);
//        validateFieldLength(storeDTO.getMessageToBuyers(), "messageToBuyer", 100, errors);
//
//    }
//
//    private void validateFieldLength(String fieldValue, String fieldName, int maxLength, Errors errors) {
//        if (fieldValue.length() > maxLength) {
//            errors.rejectValue(fieldName, "field.too.long", new Object[]{maxLength}, "");
//        }
//    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

