package ru.bellintegrator.educational_project.organization.dto;

import lombok.*;

/**
 * DTO класс для организации.
 * Используется для возврата при получении отфильтрованного списка организаций
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDtoForListResponse {

    /**
     * Поле id
     */
    private int id;

    /**
     * Поле название
     */
    private String name;

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
