package ru.bellintegrator.educational_project.aop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO класс при возврате void.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDtoForVoid {

    /**
     * Поле результат
     */
    private String result;

}
