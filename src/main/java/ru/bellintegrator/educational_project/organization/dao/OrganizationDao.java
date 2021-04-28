package ru.bellintegrator.educational_project.organization.dao;

import ru.bellintegrator.educational_project.organization.model.Organization;

import java.util.List;

/**
 * DAO для работы с Organization
 */
public interface OrganizationDao {
    /**
     * Получить объекты Organization в соответствиии с переданными значениями
     * @param name - название организации
     * @param inn - ИНН организации
     * @param isActive - активна ли организация
     * @return возвращает список подходящих объектов Organization
     */
    List<Organization> getOrganizations(String name, String inn, Boolean isActive);

    /**
     * Получить объект Organization по id
     * @param id - id организации
     * @return возвращает объект Organization
     */
    Organization getOrganizationById(int id);

    /**
     * Сохранить объект Organization
     * @param organization - организация
     */
    void save(Organization organization);

    /**
     * Проверить существует ли объект Organization с переданным id
     * @param orgId - id организации
     */
    boolean checkIsExistOrganization(int orgId);
}
