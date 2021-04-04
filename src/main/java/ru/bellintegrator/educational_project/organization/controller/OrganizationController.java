package ru.bellintegrator.educational_project.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.educational_project.organization.dto.OrganizationDto;
import ru.bellintegrator.educational_project.organization.dto.OrganizationDtoForList;
import ru.bellintegrator.educational_project.organization.service.OrganizationService;

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
    public List<OrganizationDtoForList> getOrganizations(@RequestBody OrganizationDto organizationDto) {
        return organizationService.getOrganizations(organizationDto);
    }

    @GetMapping("/{id:[\\d]+}")
    public OrganizationDto getOrganizationById(@PathVariable("id") String id) {
        return organizationService.getOrganizationById(id);
    }

    @PostMapping("/update")
    public void updateOrganization(@RequestBody OrganizationDto organizationDto) {
        organizationService.updateOrganization(organizationDto);
    }

    @PostMapping("/save")
    public void addOrganization(@RequestBody OrganizationDto organizationDto) {
        organizationService.addOrganization(organizationDto);
    }
}
