package ru.bellintegrator.educational_project.organization.dto;

import lombok.*;

/**
 * DTO класс для организации.
 * Используется для возврата при получении организации
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDtoForSaveResponse {

    /**
     * Поле id
     */
    private Integer id;

    /**
     * Поле название
     */
    private String name;

    /**
     * Поле полное название
     */
    private String fullName;

    /**
     * Поле ИНН
     */
    private String inn;

    /**
     * Поле КПП
     */
    private String kpp;

    /**
     * Поле адрес
     */
    private String address;

    /**
     * Поле телефон
     */
    private String phone;

    /**
     * Поле активна ли организация
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
