package ru.bellintegrator.educational_project.user.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
public class UserDtoForSaveRequest {

    @NotEmpty(message = "officeId cannot be null")
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

    @Size(max = 2)
    private String docCode;

    @Size(max = 100)
    private String docName;

    @Size(max = 50)
    private String docNumber;

    private Date docDate;

    @Size(max = 3)
    private String citizenshipCode;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Boolean isIdentified;


    public Boolean getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(Boolean identified) {
        isIdentified = identified;
    }
}
