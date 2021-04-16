package ru.bellintegrator.educational_project.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.educational_project.exception.NotFoundElementException;
import ru.bellintegrator.educational_project.organization.dto.*;
import ru.bellintegrator.educational_project.organization.service.OrganizationService;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping("/list")
    public ResponseEntity<List<OrganizationDtoForListResponse>> getOrganizations(@RequestBody @Valid OrganizationDtoForListRequest organizationDto,
                                                                                 BindingResult bindingResult)
            throws NumberFormatException, NotFoundElementException {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return new ResponseEntity<>(organizationService.getOrganizations(organizationDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDtoForSaveResponse> getOrganizationById(@PathVariable("id") String id) throws NotFoundElementException {
        return new ResponseEntity<>(organizationService.getOrganizationById(id), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<HttpStatus> updateOrganization(@RequestBody @Valid OrganizationDtoForUpdate organizationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        organizationService.updateOrganization(organizationDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> addOrganization(@RequestBody @Valid OrganizationDtoForSaveRequest organizationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        organizationService.addOrganization(organizationDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
