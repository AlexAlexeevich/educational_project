package ru.bellintegrator.educational_project.organization.service;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.educational_project.organization.dto.OrganizationDto;
import ru.bellintegrator.educational_project.organization.dto.OrganizationDtoForList;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface OrganizationService {

    List<OrganizationDtoForList> getOrganizations(@Valid OrganizationDto organizationDto);

    OrganizationDto getOrganizationById(String id);

    void updateOrganization(@Valid OrganizationDto organizationDto);

    void addOrganization(@Valid OrganizationDto organizationDto);

}
