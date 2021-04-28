package ru.bellintegrator.educational_project.office.dao;

import ru.bellintegrator.educational_project.office.model.Office;

import java.util.List;

/**
 * DAO для работы с Office
 */
public interface OfficeDao {

    /**
     * Получить объекты Office в соответствиии с переданными значениями
     * @param orgId - id организации
     * @param name - название офиса
     * @param phone - номер телефона
     * @param isActive - активен ли офис
     * @return возвращает список подходящих объектов Office
     */
    List<Office> getOffices(int orgId, String name, String phone, Boolean isActive);

    /**
     * Получить объект Office по id
     * @param id - id офиса
     * @return возвращает объект Office
     */
    Office getOfficeById(int id);

    /**
     * Сохранить объект Office
     * @param office - офис
     */
    void save(Office office);

    /**
     * Проверить существует ли объект Office с переданным id
     * @param officeId - id офиса
     */
    boolean checkIsExistOffice(int officeId);
}
