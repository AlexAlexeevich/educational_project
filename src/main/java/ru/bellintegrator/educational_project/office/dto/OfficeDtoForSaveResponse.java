package ru.bellintegrator.educational_project.office.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeDtoForSaveResponse {

    private Integer id;

    private String name;

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
