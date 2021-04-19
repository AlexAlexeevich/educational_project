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

@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping("/list")
    public ResponseEntity<List<OfficeDtoForListResponse>> getOffices(@RequestBody @Valid OfficeDtoForListRequest officeDto,
                                                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return new ResponseEntity<>(officeService.getOffices(officeDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfficeDtoForSaveResponse> getOfficeById(@PathVariable("id") String id) {
        return new ResponseEntity<>(officeService.getOfficeById(id), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<HttpStatus> updateOffice(@RequestBody @Valid OfficeDtoForUpdate officeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        officeService.updateOffice(officeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> addOffice(@RequestBody @Valid OfficeDtoForSaveRequest officeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        officeService.addOffice(officeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
