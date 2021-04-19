package ru.bellintegrator.educational_project.office.service;

import ru.bellintegrator.educational_project.office.dto.*;

import java.util.List;

public interface OfficeService {

    List<OfficeDtoForListResponse> getOffices(OfficeDtoForListRequest officeDto);

    OfficeDtoForSaveResponse getOfficeById(String id);

    void updateOffice(OfficeDtoForUpdate officeDto);

    void addOffice(OfficeDtoForSaveRequest officeDto);
}
