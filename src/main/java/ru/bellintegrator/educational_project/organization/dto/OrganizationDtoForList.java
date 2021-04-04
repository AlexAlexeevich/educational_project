package ru.bellintegrator.educational_project.organization.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class OrganizationDtoForList {

    private int id;

    private String name;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private boolean isActive;

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }
}
