package ru.bellintegrator.educational_project.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoForListRequest {

    @NotNull(message = "Office id cannot be null")
    private Integer officeId;

    @Size(max = 100, message = "First name cannot be more than 100 characters")
    private String firstName;

    @Size(max = 100, message = "Last name cannot be more than 100 characters")
    private String lastName;

    @Size(max = 100, message = "Middle name cannot be more than 100 characters")
    private String middleName;

    @Size(max = 50, message = "Position cannot be more than 50 characters")
    private String position;

    @Size(max = 2, message = "Doc code cannot be more than 2 characters")
    private String docCode;

    @Size(max = 3, message = "Citizenship code cannot be more than 3 characters")
    private String citizenshipCode;

}
