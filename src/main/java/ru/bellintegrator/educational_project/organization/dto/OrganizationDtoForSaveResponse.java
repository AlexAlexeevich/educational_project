package ru.bellintegrator.educational_project.organization.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class OrganizationDtoForSaveResponse {

    private Integer id;

    private String name;

    private String fullName;

    private String inn;

    private String kpp;

    private String address;

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