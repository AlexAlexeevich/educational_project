package ru.bellintegrator.educational_project.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * DTO класс для работника.
 * Используется, чтобы задать фильтрацию для списка работников
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoForListRequest {

    /**
     * Поле id офиса
     */
    @NotNull(message = "Office id cannot be null")
    private Integer officeId;

    /**
     * Поле имя
     */
    @Size(max = 100, message = "First name cannot be more than 100 characters")
    private String firstName;

    /**
     * Поле фамилия
     */
    @Size(max = 100, message = "Last name cannot be more than 100 characters")
    private String lastName;

    /**
     * Поле отчество
     */
    @Size(max = 100, message = "Middle name cannot be more than 100 characters")
    private String middleName;

    /**
     * Поле должность
     */
    @Size(max = 50, message = "Position cannot be more than 50 characters")
    private String position;

    /**
     * Поле код документа
     */
    @Size(max = 2, message = "Doc code cannot be more than 2 characters")
    private String docCode;

    /**
     * Поле код гражданства
     */
    @Size(max = 3, message = "Citizenship code cannot be more than 3 characters")
    private String citizenshipCode;

}
