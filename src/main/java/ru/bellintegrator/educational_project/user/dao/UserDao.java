package ru.bellintegrator.educational_project.user.dao;

import ru.bellintegrator.educational_project.user.model.User;

import java.util.List;

/**
 * DAO для работы с User
 */
public interface UserDao {
    /**
     * Получить объекты User в соответствиии с переданными значениями
     * @param officeId - id офиса
     * @param firstName - имя
     * @param lastName - фамилия
     * @param middleName - отчество
     * @param position - должность
     * @param docCode - код документа
     * @param citizenshipCode - код гражданства
     * @return возвращает список подходящих объектов User
     */
    List<User> getUsers(Integer officeId, String firstName, String lastName, String middleName,
                       String position, String docCode, String citizenshipCode);

    /**
     * Получить объект User по id
     * @param id - id работника
     * @return возвращает объект User
     */
    User getUserById(int id);

    /**
     * Сохранить объект User
     * @param user - работник
     */
    void save(User user);
}
