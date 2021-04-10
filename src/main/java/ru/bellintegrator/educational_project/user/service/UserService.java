package ru.bellintegrator.educational_project.user.service;

import ru.bellintegrator.educational_project.user.dto.*;

import javax.validation.Valid;
import java.util.List;

public interface UserService {

    List<UserDtoForListResponse> getUsers(@Valid UserDtoForListRequest officeDto);

    UserDtoForSaveResponse getUserById(String id);

    void updateUser(@Valid UserDtoForUpdate userDto);

    void addUser(@Valid UserDtoForSaveRequest userDto);
}
