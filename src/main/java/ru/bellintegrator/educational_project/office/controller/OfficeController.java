package ru.bellintegrator.educational_project.office.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.educational_project.office.dto.*;
import ru.bellintegrator.educational_project.office.service.OfficeService;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Класс REST-контроллер для работы с офисами.
 */
@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    /**
     * Поле officeService
     */
    private final OfficeService officeService;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param officeService - объект officeService
     */
    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    /**
     * Получить список офисов в соответствии с переданным значением
     * @param officeDto - объект-фильтр Dto
     * @param bindingResult - объект для проверки ошибок
     * @return возвращает список подходящих офисов
     */
    @PostMapping("/list")
    public ResponseEntity<List<OfficeDtoForListResponse>> getOffices(@RequestBody @Valid OfficeDtoForListRequest officeDto,
                                                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return new ResponseEntity<>(officeService.getOffices(officeDto), HttpStatus.OK);
    }

    /**
     * Получить офис по id
     * @param id - id
     * @return возвращает офис
     */
    @GetMapping("/{id}")
    public ResponseEntity<OfficeDtoForSaveResponse> getOfficeById(@PathVariable("id") String id) {
        return new ResponseEntity<>(officeService.getOfficeById(id), HttpStatus.OK);
    }

    /**
     * Изменить офис в соответствии с переданным значением
     * @param officeDto - объект-фильтр Dto
     * @param bindingResult - объект для проверки ошибок
     * @return возвращает строковой ответ был ли изменен офис
     */
    @PostMapping("/update")
    public ResponseEntity<HttpStatus> updateOffice(@RequestBody @Valid OfficeDtoForUpdate officeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        officeService.updateOffice(officeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Сохранить офис
     * @param officeDto - объект для сохранения
     * @param bindingResult - объект для проверки ошибок
     * @return возвращает строковой ответ был ли сохранен офис
     */
    @PostMapping("/save")
    public ResponseEntity<HttpStatus> addOffice(@RequestBody @Valid OfficeDtoForSaveRequest officeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        officeService.addOffice(officeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
