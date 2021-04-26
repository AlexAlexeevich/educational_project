package ru.bellintegrator.educational_project.organization.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDtoForListResponse {

    private int id;

    private String name;

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
