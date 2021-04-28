package ru.bellintegrator.educational_project.aop.dto;

import lombok.Data;

/**
 * DTO класс при Exception.
 */
@Data
public class ErrorDto {

    /**
     * Поле ошибка
     */
    private String error;
}
