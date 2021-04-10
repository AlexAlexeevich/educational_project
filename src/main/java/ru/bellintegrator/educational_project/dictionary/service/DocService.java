package ru.bellintegrator.educational_project.dictionary.service;

import ru.bellintegrator.educational_project.dictionary.dto.DocDtoForListResponse;

import java.util.List;

public interface DocService {

    List<DocDtoForListResponse> getDocs();
}
