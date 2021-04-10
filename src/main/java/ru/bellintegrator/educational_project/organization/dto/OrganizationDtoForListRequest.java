package ru.bellintegrator.educational_project.organization.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class OrganizationDtoForListRequest {

    @Size(max = 100)
    @NotEmpty(message = "name cannot be null")
    private String name;

    @Size(max = 12)
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
