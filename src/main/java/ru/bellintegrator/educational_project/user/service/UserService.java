package ru.bellintegrator.educational_project.user.service;

import ru.bellintegrator.educational_project.user.dto.*;

import java.util.List;

public interface UserService {

    List<UserDtoForListResponse> getUsers(UserDtoForListRequest officeDto);

    UserDtoForSaveResponse getUserById(String id);

    void updateUser(UserDtoForUpdate userDto);

    void addUser(UserDtoForSaveRequest userDto);
}
