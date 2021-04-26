package ru.bellintegrator.educational_project.office.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeDtoForListResponse {

    private Integer id;

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
