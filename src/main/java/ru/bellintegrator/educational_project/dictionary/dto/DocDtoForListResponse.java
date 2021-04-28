package ru.bellintegrator.educational_project.dictionary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO класс для документа.
 * Используется при получении списка объектов Doc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocDtoForListResponse {

    /**
     * Поле название
     */
    private String name;

    /**
     * Поле код
     */
    private String code;

}
