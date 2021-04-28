package ru.bellintegrator.educational_project.dictionary.service;

import ru.bellintegrator.educational_project.dictionary.dto.DocDtoForListResponse;

import java.util.List;

/**
 * Сервис для работы с Country
 */
public interface DocService {

    /**
     * Получить список всех видов документов
     * @return возвращает список всех видов документов
     */
    List<DocDtoForListResponse> getDocs();
}
