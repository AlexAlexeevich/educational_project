package ru.bellintegrator.educational_project.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.educational_project.aop.dto.ErrorDto;
import ru.bellintegrator.educational_project.exception.NotFoundElementException;

import javax.validation.ValidationException;

@RestControllerAdvice
public class ExceptionHandlerController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler({NotFoundElementException.class, NumberFormatException.class, ValidationException.class,
            Exception.class})
    public ResponseEntity<ErrorDto> noElementException(Exception e) {

        ErrorDto errorDto = new ErrorDto();
        errorDto.setError(e.getMessage());

        if (e.getClass() == NotFoundElementException.class) {
            return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
        } else if (e.getClass() == NumberFormatException.class) {
            return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
        } else if (e.getClass() == ValidationException.class) {
            return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
        } else {
            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
            int l = 10;
            StringBuilder stringBuilder = new StringBuilder(l);
            for (int i = 0; i < l; i++) {
                int index = (int) (AlphaNumericString.length() * Math.random());
                stringBuilder.append(AlphaNumericString.charAt(index));
            }
            logger.error("Unexpected error № " + stringBuilder.toString(), e);

            errorDto.setError("Server Error № " + stringBuilder.toString());
            return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
