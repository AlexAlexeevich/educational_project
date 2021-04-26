package ru.bellintegrator.educational_project.office.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeDtoForUpdate {

    @NotNull(message = "Id cannot be null")
    private Integer id;

    @Size(max = 100, message = "Name cannot be more than 100 characters")
    @NotEmpty(message = "Name cannot be null")
    private String name;

    @Size(max = 200, message = "Address cannot be more than 200 characters")
    @NotEmpty(message = "Address cannot be null")
    private String address;

    @Size(max = 25, message = "Phone cannot be more than 200 characters")
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
