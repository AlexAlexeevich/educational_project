package ru.bellintegrator.educational_project.office.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class OfficeDtoForUpdate {

    @NotEmpty
    private Integer id;

    @Size(max = 100)
    @NotEmpty(message = "name cannot be null")
    private String name;

    @Size(max = 200)
    @NotEmpty(message = "address cannot be null")
    private String address;

    @Size(max = 25)
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
