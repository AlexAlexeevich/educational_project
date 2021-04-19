package ru.bellintegrator.educational_project.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.educational_project.user.dto.*;
import ru.bellintegrator.educational_project.user.service.UserService;

import javax.validation.Valid;
import javax.validation.ValidationException;
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
    public ResponseEntity<List<UserDtoForListResponse>> getUsers(@RequestBody @Valid UserDtoForListRequest UserDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return new ResponseEntity<>(userService.getUsers(UserDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoForSaveResponse> getUserById(@PathVariable("id") String id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<HttpStatus> updateOffice(@RequestBody @Valid UserDtoForUpdate userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        userService.updateUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> adduser(@RequestBody @Valid UserDtoForSaveRequest userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        userService.addUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
