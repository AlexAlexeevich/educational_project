package ru.bellintegrator.educational_project.dictionary.service;

import ru.bellintegrator.educational_project.dictionary.dto.CountryDtoForListResponse;

import java.util.List;

/**
 * Сервис для работы с Country
 */
public interface CountryService {

    /**
     * Получить список всех стран
     * @return возвращает список всех стран
     */
    List<CountryDtoForListResponse> getCountries();

}
