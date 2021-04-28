package ru.bellintegrator.educational_project.office.service;

import ru.bellintegrator.educational_project.office.dto.*;

import java.util.List;

/**
 * Сервис для работы с Office
 */
public interface OfficeService {

    /**
     * Получить список офисов в соответствии с переданным значением
     * @param officeDto - объект-фильтр Dto
     * @return возвращает список подходящих офисов
     */
    List<OfficeDtoForListResponse> getOffices(OfficeDtoForListRequest officeDto);

    /**
     * Получить офис по id
     * @param id - id
     * @return возвращает офис
     */
    OfficeDtoForSaveResponse getOfficeById(String id);

    /**
     * Изменить офис в соответствии с переданным значением
     * @param officeDto - объект-фильтр Dto
     */
    void updateOffice(OfficeDtoForUpdate officeDto);

    /**
     * Сохранить офис
     * @param officeDto - объект для сохранения
     */
    void addOffice(OfficeDtoForSaveRequest officeDto);
}
