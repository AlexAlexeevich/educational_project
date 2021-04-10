package ru.bellintegrator.educational_project.organization.service;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.educational_project.organization.dto.*;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface OrganizationService {

    List<OrganizationDtoForListResponse> getOrganizations(@Valid OrganizationDtoForListRequest organizationDto);

    OrganizationDtoForSaveResponse getOrganizationById(String id);

    void updateOrganization(@Valid OrganizationDtoForUpdate organizationDto);

    void addOrganization(@Valid OrganizationDtoForSaveRequest organizationDto);

}
