package ru.bellintegrator.educational_project.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.educational_project.aop.dto.ErrorDto;
import ru.bellintegrator.educational_project.exception.NotFoundElementException;

import javax.validation.ValidationException;
import java.util.UUID;

/**
 * Класс обрабатывающий исключения возникающие после вызовов методов контроллеров
 */
@RestControllerAdvice
public class ExceptionHandlerController {

    /**
     * Поле logger, используемое для логирования
     */
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    /**
     * Обработать исключения возникшие после вызовов методов контроллеров
     */
    @ExceptionHandler({NotFoundElementException.class, NumberFormatException.class, ValidationException.class,
            HttpMessageNotReadableException.class, Exception.class})
    public ResponseEntity<ErrorDto> noElementException(Exception e) {

        ErrorDto errorDto = new ErrorDto();
        errorDto.setError(e.getMessage());

        if (e.getClass() == NotFoundElementException.class) {
            return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
        } else if (e.getClass() == NumberFormatException.class) {
            return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
        } else if (e.getClass() == ValidationException.class) {
            return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
        } else if (e.getClass() == HttpMessageNotReadableException.class) {
            errorDto.setError("Invalid data entered");
            return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
        } else {
            UUID uuid = UUID.randomUUID();
            logger.error("Unexpected error № " + uuid.toString(), e);
            errorDto.setError("Server Error № " + uuid.toString());

            return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
