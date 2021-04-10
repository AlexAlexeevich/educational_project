package ru.bellintegrator.educational_project.user.dto;

import lombok.Data;

@Data
public class UserDtoForListResponse {

    private Integer id;

    private String firstName;

    private String secondName;

    private String middleName;

    private String position;
}
