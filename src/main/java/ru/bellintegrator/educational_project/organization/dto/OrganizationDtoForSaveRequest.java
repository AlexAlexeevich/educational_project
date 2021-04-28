package ru.bellintegrator.educational_project.organization.dto;

import lombok.*;

import javax.validation.constraints.*;

/**
 * DTO класс для организации.
 * Используется, чтобы задать фильтрацию при добавления организации
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDtoForSaveRequest {

    /**
     * Поле название
     */
    @Size(max = 100, message = "Name cannot be more than 100 characters")
    @NotEmpty(message = "Name cannot be null")
    private String name;

    /**
     * Поле полное название
     */
    @Size(max = 100, message = "Full name cannot be more than 100 characters")
    @NotEmpty(message = "Full name cannot be null")
    private String fullName;

    /**
     * Поле ИНН
     */
    @Size(max = 12, message = "Inn cannot be more than 12 characters")
    @NotEmpty(message = "Inn cannot be null")
    private String inn;

    /**
     * Поле КПП
     */
    @Size(max = 9, message = "Kpp cannot be more than 9 characters")
    @NotEmpty(message = "Kpp cannot be null")
    private String kpp;

    /**
     * Поле адрес
     */
    @Size(max = 200, message = "Name cannot be more than 200 characters")
    @NotEmpty(message = "Address cannot be null")
    private String address;

    /**
     * Поле телефон
     */
    @Size(max = 25, message = "Phone cannot be more than 25 characters")
    private String phone;

    /**
     * Поле активна ли организация
     */
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    public Boolean isActive;

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
