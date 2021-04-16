package ru.bellintegrator.educational_project.organization.service;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.educational_project.exception.NotFoundElementException;
import ru.bellintegrator.educational_project.organization.dto.*;

import java.util.List;

@Validated
public interface OrganizationService {

    List<OrganizationDtoForListResponse> getOrganizations(OrganizationDtoForListRequest organizationDto) throws NotFoundElementException;

    OrganizationDtoForSaveResponse getOrganizationById(String id) throws NotFoundElementException;

    void updateOrganization(OrganizationDtoForUpdate organizationDto);

    void addOrganization(OrganizationDtoForSaveRequest organizationDto);

}
