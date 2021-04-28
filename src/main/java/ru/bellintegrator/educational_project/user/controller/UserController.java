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

/**
 * Класс REST-контроллер для работы с работниками.
 */
@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    /**
     * Поле userService
     */
    private final UserService userService;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param userService - объект userService
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Получить список работников в соответствии с переданным значением
     * @param userDto - объект-фильтр Dto
     * @param bindingResult - объект для проверки ошибок
     * @return возвращает список подходящих работников
     */
    @PostMapping("/list")
    public ResponseEntity<List<UserDtoForListResponse>> getUsers(@RequestBody @Valid UserDtoForListRequest userDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return new ResponseEntity<>(userService.getUsers(userDto), HttpStatus.OK);
    }

    /**
     * Получить работника по id
     * @param id - id
     * @return возвращает работника
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDtoForSaveResponse> getUserById(@PathVariable("id") String id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    /**
     * Изменить работника в соответствии с переданным значением
     * @param userDto - объект-фильтр Dto
     * @param bindingResult - объект для проверки ошибок
     * @return возвращает строковой ответ был ли изменен работник
     */
    @PostMapping("/update")
    public ResponseEntity<HttpStatus> updateOffice(@RequestBody @Valid UserDtoForUpdate userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        userService.updateUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Сохранить работника
     * @param userDto - объект для сохранения
     * @param bindingResult - объект для проверки ошибок
     * @return возвращает строковой ответ был ли сохранен работник
     */
    @PostMapping("/save")
    public ResponseEntity<HttpStatus> adduser(@RequestBody @Valid UserDtoForSaveRequest userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        userService.addUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
