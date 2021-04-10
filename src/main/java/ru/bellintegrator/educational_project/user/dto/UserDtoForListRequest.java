package ru.bellintegrator.educational_project.user.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserDtoForListRequest {

    @NotEmpty
    private Integer officeId;

    @Size(max = 100)
    private String firstName;

    @Size(max = 100)
    private String lastName;

    @Size(max = 100)
    private String middleName;

    @Size(max = 50)
    private String position;

    @Size(max = 2)
    private String docCode;

    @Size(max = 3)
    private String citizenshipCode;

}
