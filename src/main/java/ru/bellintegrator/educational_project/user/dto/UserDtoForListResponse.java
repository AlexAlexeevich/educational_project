package ru.bellintegrator.educational_project.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoForListResponse {

    private Integer id;

    private String firstName;

    private String secondName;

    private String middleName;

    private String position;
}
