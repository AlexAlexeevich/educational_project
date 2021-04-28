package ru.bellintegrator.educational_project.office.dto;

import lombok.*;

/**
 * DTO класс для офиса.
 * Используется для возврата при получении отфильтрованного списка офисов
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeDtoForListResponse {

    /**
     * Поле id
     */
    private Integer id;

    /**
     * Поле название
     */
    private String name;

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
