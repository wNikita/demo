package com.example.demo.validation;

import com.example.demo.Comman.Constant;
import com.example.demo.Comman.EmailValidate;
import com.example.demo.dto.StoreDTO;
import com.example.demo.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class StoreValidator implements Validator {

    private StoreRepository storeRepository;
    @Autowired
    private EmailValidate emailValidate;

    public StoreValidator(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return StoreDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        StoreDTO storeDTO = (StoreDTO) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status", "storeStatus.required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "storeName.required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "storeEmail.required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "storeTitle.required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "iconPath", "storeIconPath.required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storeAddress", "storeAddress.required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storyTitle", "storyTitle.required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storyDescription", "storyDescription.required.field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messageToBuyers", "messageToBuyers.required.field");

        if (!emailValidate.isValidEmail(storeDTO.getEmail())) {
            errors.rejectValue("email", "field.invalidEmail");
        }
        if (storeRepository.existsByName(storeDTO.getName())) {
            errors.rejectValue("name", "unique.storeName");
        }
        if(storeRepository.existsByEmail(storeDTO.getEmail()))
        {
            errors.rejectValue("email","unique.email");
        }

        validateFieldLength(storeDTO.getStatus(), "status", Constant.STORE_STATUS, errors);
        validateFieldLength(storeDTO.getName(), "name", Constant.STORE_NAME, errors);
        validateFieldLength(storeDTO.getTitle(), "title", Constant.STORE_TITLE, errors);
        validateFieldLength(storeDTO.getEmail(), "email", Constant.STORE_EMAIL, errors);
        validateFieldLength(storeDTO.getStoryTitle(), "storyTitle", Constant.STORE_STORY_TITLE, errors);
        validateFieldLength(storeDTO.getAnnouncementTitle(), "announcementTitle", Constant.STORE_ANNOUNCEMENT_TITLE, errors);
        validateFieldLength(storeDTO.getMessageToBuyers(), "messageToBuyer", Constant.STORE_MESSAGE_TO_BUYER, errors);

    }

    private void validateFieldLength(String fieldValue, String fieldName, int maxLength, Errors errors) {
        if (!(fieldValue == null) && fieldValue.length() > maxLength) {
            errors.rejectValue(fieldName, "field.too.long", new Object[]{maxLength}, "");
        }
    }
}


