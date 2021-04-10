package ru.bellintegrator.educational_project.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.educational_project.user.dto.*;
import ru.bellintegrator.educational_project.user.service.UserService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/list")
    public List<UserDtoForListResponse> getUsers(@RequestBody UserDtoForListRequest UserDto) {
        return userService.getUsers(UserDto);
    }

    @GetMapping("/{id:[\\d]+}")
    public UserDtoForSaveResponse getUserById(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/update")
    public void updateOffice(@RequestBody UserDtoForUpdate userDto) {
        userService.updateUser(userDto);
    }

    @PostMapping("/save")
    public void adduser(@RequestBody UserDtoForSaveRequest userDto) {
        userService.addUser(userDto);
    }
}
