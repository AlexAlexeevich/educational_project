package ru.bellintegrator.educational_project.organization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.educational_project.organization.dao.OrganizationDao;
import ru.bellintegrator.educational_project.organization.dto.*;
import ru.bellintegrator.educational_project.organization.model.Organization;
import ru.bellintegrator.educational_project.mapper.MapperFacade;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao organizationDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao, MapperFacade mapperFacade) {
        this.organizationDao = organizationDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationDtoForListResponse> getOrganizations(OrganizationDtoForListRequest organizationDto) {
        List<Organization> organizations = organizationDao.getOrganizations(organizationDto.getName(),
                organizationDto.getInn(), organizationDto.getIsActive());
        return mapperFacade.mapAsList(organizations, OrganizationDtoForListResponse.class);
    }

    @Override
    @Transactional(readOnly = true)
    public OrganizationDtoForSaveResponse getOrganizationById(String id) {
        Organization organization = organizationDao.getOrganizationById(Integer.parseInt(id));
        return mapperFacade.map(organization, OrganizationDtoForSaveResponse.class);
    }

    @Override
    @Transactional
    public void updateOrganization(OrganizationDtoForUpdate organizationDto) {
        Organization organization = organizationDao.getOrganizationById(organizationDto.getId());
        mapperFacade.map(organizationDto, organization);
    }

    @Override
    @Transactional
    public void addOrganization(OrganizationDtoForSaveRequest organizationDto) {
        Organization organization = mapperFacade.map(organizationDto, Organization.class);
        organizationDao.save(organization);
    }
}
