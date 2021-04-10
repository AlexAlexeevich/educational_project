package ru.bellintegrator.educational_project.dictionary.service;

import ru.bellintegrator.educational_project.dictionary.dto.CountryDtoForListResponse;

import java.util.List;

public interface CountryService {

    List<CountryDtoForListResponse> getCountries();

}
