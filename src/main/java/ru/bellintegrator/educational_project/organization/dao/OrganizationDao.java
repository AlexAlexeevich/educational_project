package ru.bellintegrator.educational_project.organization.dao;

import ru.bellintegrator.educational_project.organization.model.Organization;

import java.util.List;

public interface OrganizationDao {

    List<Organization> getOrganizations(String name, String inn, Boolean isActive);

    Organization getOrganizationById(int id);

    void save(Organization organization);

}
