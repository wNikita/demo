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
        StoreDTO storeDTO=(StoreDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"storeStatus","filed.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userId","filed.required");
        ValidationUtils.rejectIfEmpty(errors,"name","filed.required");
        ValidationUtils.rejectIfEmpty(errors,"title","filed.required");
        ValidationUtils.rejectIfEmpty(errors,"email","filed.required");
        ValidationUtils.rejectIfEmpty(errors,"iconPath","filed.required");
        ValidationUtils.rejectIfEmpty(errors,"announcementTitle","filed.required");
        ValidationUtils.rejectIfEmpty(errors,"storyTitle","filed.required");

        if(!storeDTO.getOrderCustomizationAllowed())
        {
            errors.rejectValue("orderCustomizationAllowed","invalid.value");
        }
        if(!storeDTO.getVacationMode())
        {
            errors.rejectValue("vacationMode","invalid.value");
        }
    }
}
