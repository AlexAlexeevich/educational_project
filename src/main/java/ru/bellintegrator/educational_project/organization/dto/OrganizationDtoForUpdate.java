package ru.bellintegrator.educational_project.organization.dto;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Data
public class OrganizationDtoForUpdate {

    @NotNull(message = "Name cannot be empty")
    private Integer id;

    @Size(max = 100, message = "Name cannot be more than 100 characters")
    @NotEmpty(message = "Name cannot be null")
    private String name;

    @Size(max = 100, message = "Full Name cannot be more than 100 characters")
    @NotEmpty(message = "Full name cannot be null")
    private String fullName;

    @Size(max = 12, message = "Inn cannot be more than 12 characters")
    @NotEmpty(message = "Inn cannot be null")
    private String inn;

    @Size(max = 9, message = "Kpp cannot be more than 9 characters")
    @NotEmpty(message = "Kpp cannot be null")
    private String kpp;

    @Size(max = 200, message = "Inn cannot be more than 200 characters")
    @NotEmpty(message = "Address cannot be null")
    private String address;

    @Size(max = 25, message = "Inn cannot be more than 25 characters")
    private String phone;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Boolean isActive;

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}
