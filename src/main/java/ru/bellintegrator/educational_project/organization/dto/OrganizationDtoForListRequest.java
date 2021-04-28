package ru.bellintegrator.educational_project.organization.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * DTO класс для организации.
 * Используется, чтобы задать фильтрацию для списка организаций
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDtoForListRequest {

    /**
     * Поле название
     */
    @Size(max = 100, message = "Name cannot be more than 100 characters")
    @NotEmpty(message = "Name cannot be null")
    private String name;

    /**
     * Поле ИНН
     */
    @Size(max = 12, message = "Inn cannot be more than 12 characters")
    private String inn;

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
