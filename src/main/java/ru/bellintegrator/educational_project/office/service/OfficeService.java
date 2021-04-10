package ru.bellintegrator.educational_project.office.service;

import ru.bellintegrator.educational_project.office.dto.*;

import javax.validation.Valid;
import java.util.List;

public interface OfficeService {

    List<OfficeDtoForListResponse> getOffices(@Valid OfficeDtoForListRequest officeDto);

    OfficeDtoForSaveResponse getOfficeById(String id);

    void updateOffice(@Valid OfficeDtoForUpdate officeDto);

    void addOffice(@Valid OfficeDtoForSaveRequest officeDto);
}
