package ru.bellintegrator.educational_project.organization.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class OrganizationDtoForListRequest {

    @Size(max = 100, message = "Name cannot be more than 100 characters")
    @NotEmpty(message = "Name cannot be null")
    private String name;

    @Size(max = 12, message = "Inn cannot be more than 12 characters")
    private String inn;

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
