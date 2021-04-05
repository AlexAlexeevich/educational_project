package ru.bellintegrator.educational_project.organization.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Data
public class OrganizationDtoForSave {

    @Size(max = 100)
    @NotEmpty(message = "name cannot be null")
    public String name;

    @Size(max = 100)
    @NotEmpty(message = "fullName cannot be null")
    public String fullName;

    @Size(max = 12)
    @NotEmpty(message = "inn cannot be null")
    public String inn;

    @Size(max = 9)
    @NotEmpty(message = "kpp cannot be null")
    public String kpp;

    @Size(max = 200)
    @NotEmpty(message = "address cannot be null")
    public String address;

    @Size(max = 25)
    public String phone;

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
