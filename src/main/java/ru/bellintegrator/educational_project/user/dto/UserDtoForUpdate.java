package ru.bellintegrator.educational_project.user.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

/**
 * DTO класс для работника.
 * Используется, чтобы задать фильтрацию при изменении работника
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoForUpdate {

    /**
     * Поле id
     */
    @NotNull(message = "Id cannot be null")
    private Integer id;

    /**
     * Поле id офиса
     */
    private Integer officeId;

    /**
     * Поле имя
     */
    @Size(max = 100, message = "First name cannot be more than 100 characters")
    @NotEmpty(message = "First name cannot be null")
    private String firstName;

    /**
     * Поле фамилия
     */
    @Size(max = 100, message = "Second name cannot be more than 100 characters")
    private String secondName;

    /**
     * Поле отчество
     */
    @Size(max = 100, message = "Middle name cannot be more than 100 characters")
    private String middleName;

    /**
     * Поле должность
     */
    @NotEmpty(message = "Position cannot be null")
    @Size(max = 50, message = "Position cannot be more than 50 characters")
    private String position;

    /**
     * Поле телефон
     */
    @Size(max = 25, message = "Phone cannot be more than 25 characters")
    private String phone;

    /**
     * Поле название документа
     */
    @Size(max = 100, message = "Doc name cannot be more than 100 characters")
    private String docName;

    /**
     * Поле номер документа
     */
    @Size(max = 50, message = "Doc number cannot be more than 50 characters")
    private String docNumber;

    /**
     * Поле дата документа
     */
    private Date docDate;

    /**
     * Поле код страны гражданства
     */
    @Size(max = 3, message = "Citizenship code cannot be more than 3 characters")
    private String citizenshipCode;

    /**
     * Поле идентифицирован ли работник
     */
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Boolean isIdentified;

    /**
     * Вернуть значение поля isIdentified
     * @return возвращает значение поля isIdentified
     */
    public Boolean getIsIdentified() {
        return isIdentified;
    }

    /**
     * Задать значение поля isIdentified
     */
    public void setIsIdentified(Boolean identified) {
        isIdentified = identified;
    }
}