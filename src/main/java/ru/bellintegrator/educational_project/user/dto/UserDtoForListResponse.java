package ru.bellintegrator.educational_project.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO класс для работника.
 * Используется для возврата при получении отфильтрованного списка работников
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoForListResponse {

    /**
     * Поле id
     */
    private Integer id;

    /**
     * Поле имя
     */
    private String firstName;

    /**
     * Поле фамилия
     */
    private String secondName;

    /**
     * Поле отчество
     */
    private String middleName;

    /**
     * Поле должность
     */
    private String position;
}
