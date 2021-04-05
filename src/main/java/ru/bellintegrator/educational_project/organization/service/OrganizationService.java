package ru.bellintegrator.educational_project.organization.service;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.educational_project.organization.dto.OrganizationDtoForUpdate;
import ru.bellintegrator.educational_project.organization.dto.OrganizationDtoForListResponse;
import ru.bellintegrator.educational_project.organization.dto.OrganizationDtoForListRequest;
import ru.bellintegrator.educational_project.organization.dto.OrganizationDtoForSave;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface OrganizationService {

    List<OrganizationDtoForListResponse> getOrganizations(@Valid OrganizationDtoForListRequest organizationDto);

    OrganizationDtoForUpdate getOrganizationById(String id);

    void updateOrganization(@Valid OrganizationDtoForUpdate organizationDto);

    void addOrganization(@Valid OrganizationDtoForSave organizationDto);

}
