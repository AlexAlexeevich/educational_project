package ru.bellintegrator.educational_project.office.dao;

import ru.bellintegrator.educational_project.office.model.Office;

import java.util.List;

public interface OfficeDao {

    List<Office> getOffices(int orgId, String name, String phone, Boolean isActive);

    Office getOfficeById(int id);

    void save(Office office);

    boolean checkIsExistOrganization(int orgId);
}
