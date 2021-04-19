package ru.bellintegrator.educational_project.user.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
public class UserDtoForUpdate {

    @NotNull(message = "Id cannot be null")
    private Integer id;

    private Integer officeId;

    @Size(max = 100, message = "First name cannot be more than 100 characters")
    @NotEmpty(message = "First name cannot be null")
    private String firstName;

    @Size(max = 100, message = "Second name cannot be more than 100 characters")
    private String secondName;

    @Size(max = 100, message = "Middle name cannot be more than 100 characters")
    private String middleName;

    @NotEmpty(message = "Position cannot be null")
    @Size(max = 50, message = "Position cannot be more than 50 characters")
    private String position;

    @Size(max = 25, message = "Phone cannot be more than 25 characters")
    private String phone;

    @Size(max = 100, message = "Doc name cannot be more than 100 characters")
    private String docName;

    @Size(max = 50, message = "Doc number cannot be more than 50 characters")
    private String docNumber;

    private Date docDate;

    @Size(max = 3, message = "Citizenship code cannot be more than 3 characters")
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