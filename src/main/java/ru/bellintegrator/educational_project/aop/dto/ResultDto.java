package ru.bellintegrator.educational_project.aop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO класс для возврата данных.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {

    /**
     * Поле данные
     */
    private Object data;



}
