package ru.bellintegrator.educational_project.organization.service;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.educational_project.exception.NotFoundElementException;
import ru.bellintegrator.educational_project.organization.dto.*;

import java.util.List;

/**
 * Сервис для работы с Organization
 */
@Validated
public interface OrganizationService {

    /**
     * Получить список организаций в соответствии с переданным значением
     * @param organizationDto - объект-фильтр Dto
     * @return возвращает список подходящих организаций
     */
    List<OrganizationDtoForListResponse> getOrganizations(OrganizationDtoForListRequest organizationDto) throws NotFoundElementException;

    /**
     * Получить организацию по id
     * @param id - id
     * @return возвращает организацию
     */
    OrganizationDtoForSaveResponse getOrganizationById(String id) throws NotFoundElementException;

    /**
     * Изменить организацию в соответствии с переданным значением
     * @param organizationDto - объект-фильтр Dto
     */
    void updateOrganization(OrganizationDtoForUpdate organizationDto);

    /**
     * Сохранить организацию
     * @param organizationDto - объект для сохранения
     */
    void addOrganization(OrganizationDtoForSaveRequest organizationDto);

}
