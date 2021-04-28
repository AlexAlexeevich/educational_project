package ru.bellintegrator.educational_project.office.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * DTO класс для офиса.
 * Используется, чтобы задать фильтрацию при добавлении офиса
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeDtoForSaveRequest {

    /**
     * Поле id организации
     */
    @NotNull(message = "OrgId cannot be null")
    private Integer orgId;

    /**
     * Поле название
     */
    @Size(max = 100, message = "Name cannot be more than 100 characters")
    private String name;

    /**
     * Поле адрес
     */
    @Size(max = 200, message = "Address cannot be more than 200 characters")
    private String address;

    /**
     * Поле телефон
     */
    @Size(max = 25, message = "Phone cannot be more than 25 characters")
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
