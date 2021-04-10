package ru.bellintegrator.educational_project.office.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.educational_project.office.dto.*;
import ru.bellintegrator.educational_project.office.service.OfficeService;

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
    public List<OfficeDtoForListResponse> getOffices(@RequestBody OfficeDtoForListRequest officeDto) {
        return officeService.getOffices(officeDto);
    }

    @GetMapping("/{id:[\\d]+}")
    public OfficeDtoForSaveResponse getOfficeById(@PathVariable("id") String id) {
        return officeService.getOfficeById(id);
    }

    @PostMapping("/update")
    public void updateOffice(@RequestBody OfficeDtoForUpdate officeDto) {
        officeService.updateOffice(officeDto);
    }

    @PostMapping("/save")
    public void addOffice(@RequestBody OfficeDtoForSaveRequest officeDto) {
        officeService.addOffice(officeDto);
    }
}
