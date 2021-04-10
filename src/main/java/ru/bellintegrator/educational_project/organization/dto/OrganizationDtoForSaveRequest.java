package ru.bellintegrator.educational_project.organization.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Data
public class OrganizationDtoForSaveRequest {

    @Size(max = 100)
    @NotEmpty(message = "name cannot be null")
    private String name;

    @Size(max = 100)
    @NotEmpty(message = "fullName cannot be null")
    private String fullName;

    @Size(max = 12)
    @NotEmpty(message = "inn cannot be null")
    private String inn;

    @Size(max = 9)
    @NotEmpty(message = "kpp cannot be null")
    private String kpp;

    @Size(max = 200)
    @NotEmpty(message = "address cannot be null")
    private String address;

    @Size(max = 25)
    private String phone;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    public Boolean isActive;


    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}
