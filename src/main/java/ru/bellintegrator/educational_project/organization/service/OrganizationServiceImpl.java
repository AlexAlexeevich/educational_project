package ru.bellintegrator.educational_project.organization.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.educational_project.organization.dao.OrganizationDao;
import ru.bellintegrator.educational_project.organization.dto.OrganizationDto;
import ru.bellintegrator.educational_project.organization.dto.OrganizationDtoForList;
import ru.bellintegrator.educational_project.organization.model.Organization;
import ru.bellintegrator.educational_project.organization.model.mapper.MapperFacade;

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
    public List<OrganizationDtoForList> getOrganizations(OrganizationDto organizationDto) {
        List<Organization> organizations = organizationDao.getOrganizations(organizationDto.getName(),
                organizationDto.getInn(), organizationDto.getIsActive());
        return mapperFacade.mapAsList(organizations, OrganizationDtoForList.class);
    }

    @Override
    @Transactional(readOnly = true)
    public OrganizationDto getOrganizationById(String id) {
        Organization organization = organizationDao.getOrganizationById(Integer.parseInt(id));
        return mapperFacade.map(organization, OrganizationDto.class);
    }

    @Override
    @Transactional
    public void updateOrganization(OrganizationDto organizationDto) {
        Organization organization = mapperFacade.map(organizationDto, Organization.class);
        organizationDao.updateOrganization(organization);
    }

    @Override
    @Transactional
    public void addOrganization(OrganizationDto organizationDto) {
        Organization organization = mapperFacade.map(organizationDto, Organization.class);
        organizationDao.save(organization);
    }
}
