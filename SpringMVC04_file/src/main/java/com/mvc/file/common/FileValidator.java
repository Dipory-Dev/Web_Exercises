package com.mvc.file.common;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class FileValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UploadFile.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UploadFile file = (UploadFile) target;

        if(file.getMpfile().getSize() == 0) {
            errors.rejectValue("mpfile", "fileNPE", "Please select a file");
        }
    }
}
