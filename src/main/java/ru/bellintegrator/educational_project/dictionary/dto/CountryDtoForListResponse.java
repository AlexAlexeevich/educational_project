package ru.bellintegrator.educational_project.dictionary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO класс для страны гражданства.
 * Используется при получении списка объектов Country
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDtoForListResponse {

    /**
     * Поле название
     */
    private String name;

    /**
     * Поле код
     */
    private String code;

}
