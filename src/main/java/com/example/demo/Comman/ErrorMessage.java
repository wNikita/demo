package com.example.demo.Comman;

import com.example.demo.dto.ErrorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessage {

    @Autowired
    private MessageSource messageSource;

    public List<ErrorDetails> buildErrorResponse(BindingResult bindingResult) {
        List<ErrorDetails> errorDetailsList = new ArrayList<>();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String field = fieldError.getField();
            String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            ErrorDetails errorDetails = new ErrorDetails(field, message);
            errorDetailsList.add(errorDetails);
        }
        return errorDetailsList;
    }
}


