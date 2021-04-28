package ru.bellintegrator.educational_project.dictionary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.educational_project.dictionary.dto.CountryDtoForListResponse;
import ru.bellintegrator.educational_project.dictionary.service.CountryService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Класс REST-контроллер для работы со страной гражданства.
 */
@RestController
@RequestMapping(value = "/api/countries", produces = APPLICATION_JSON_VALUE)
public class CountryController {

    /**
     * Поле countryService
     */
    private final CountryService countryService;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param countryService - объект countryService
     */
    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * Получить список всех стран
     * @return возвращает список всех стран
     */
    @PostMapping("")
    public ResponseEntity<List<CountryDtoForListResponse>> getCountries() {
        return new ResponseEntity<>(countryService.getCountries(), HttpStatus.OK);
    }
}
