package ru.bellintegrator.educational_project.user.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserDtoForUpdate {

    @NotEmpty
    private Integer id;

    private Integer officeId;

    @Size(max = 100)
    @NotEmpty(message = "first name cannot be null")
    private String firstName;

    @Size(max = 100)
    private String secondName;

    @Size(max = 100)
    private String middleName;

    @NotEmpty(message = "position cannot be null")
    @Size(max = 50)
    private String position;

    @Size(max = 25)
    private String phone;

    @Size(max = 100)
    private String docName;

    @Size(max = 50)
    private String docNumber;

    @Size(max = 100)
    private String docDate;

    @Size(max = 3)
    private String citizenshipCode;

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