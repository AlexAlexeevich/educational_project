package ru.bellintegrator.educational_project.user.service;

import ru.bellintegrator.educational_project.user.dto.*;

import java.util.List;

/**
 * Сервис для работы с User
 */
public interface UserService {

    /**
     * Получить список работников в соответствии с переданным значением
     * @param userDto - объект-фильтр Dto
     * @return возвращает список подходящих работников
     */
    List<UserDtoForListResponse> getUsers(UserDtoForListRequest userDto);

    /**
     * Получить работника по id
     * @param id - id
     * @return возвращает работника
     */
    UserDtoForSaveResponse getUserById(String id);

    /**
     * Изменить работника в соответствии с переданным значением
     * @param userDto - объект-фильтр Dto
     */
    void updateUser(UserDtoForUpdate userDto);

    /**
     * Сохранить работника
     * @param userDto - объект для сохранения
     */
    void addUser(UserDtoForSaveRequest userDto);
}
