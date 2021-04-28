package ru.bellintegrator.educational_project.user.dto;

import lombok.*;

/**
 * DTO класс для работника.
 * Используется для возврата при получении работника
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoForSaveResponse {

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

    /**
     * Поле телефон
     */
    private String phone;

    /**
     * Поле название документа
     */
    private String docName;

    /**
     * Поле номер документа
     */
    private String docNumber;

    /**
     * Поле дата документа
     */
    private String docDate;

    /**
     * Поле название страны гражданства
     */
    private String citizenshipName;

    /**
     * Поле код страны гражданства
     */
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
