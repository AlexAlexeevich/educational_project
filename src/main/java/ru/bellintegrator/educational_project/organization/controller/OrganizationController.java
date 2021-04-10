package ru.bellintegrator.educational_project.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.educational_project.organization.dto.*;
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
    public List<OrganizationDtoForListResponse> getOrganizations(@RequestBody OrganizationDtoForListRequest organizationDto) {
        return organizationService.getOrganizations(organizationDto);
    }

    @GetMapping("/{id:[\\d]+}")
    public OrganizationDtoForSaveResponse getOrganizationById(@PathVariable("id") String id) {
        return organizationService.getOrganizationById(id);
    }

    @PostMapping("/update")
    public void updateOrganization(@RequestBody OrganizationDtoForUpdate organizationDto) {
        organizationService.updateOrganization(organizationDto);
    }

    @PostMapping("/save")
    public void addOrganization(@RequestBody OrganizationDtoForSaveRequest organizationDto) {
        organizationService.addOrganization(organizationDto);
    }
}
