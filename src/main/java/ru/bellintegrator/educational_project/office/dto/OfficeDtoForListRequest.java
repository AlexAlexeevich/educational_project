package ru.bellintegrator.educational_project.office.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeDtoForListRequest {

    @NotNull(message = "Organization id cannot be null")
    private Integer orgId;

    @Size(max = 100, message = "Name cannot be more than 100 characters")
    private String name;

    @Size(max = 25, message = "Phone cannot be more than 25 characters")
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
