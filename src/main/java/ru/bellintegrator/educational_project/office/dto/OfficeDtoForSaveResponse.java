package ru.bellintegrator.educational_project.office.dto;

import lombok.*;

/**
 * DTO класс для офиса.
 * Используется для возврата при получении офиса
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeDtoForSaveResponse {

    /**
     * Поле id
     */
    private Integer id;

    /**
     * Поле название
     */
    private String name;

    /**
     * Поле адрес
     */
    private String address;

    /**
     * Поле телефон
     */
    private String phone;

    /**
     * Поле активен ли офис
     */
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Boolean isActive;

    /**
     * Вернуть значение поля isActive
     * @return возвращает значение поля isActive
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * Задать значение поля isActive
     */
    public void setIsActive(Boolean active) {
        isActive = active;
    }
}
