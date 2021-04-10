package ru.bellintegrator.educational_project.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.educational_project.mapper.MapperFacade;
import ru.bellintegrator.educational_project.office.dao.OfficeDao;
import ru.bellintegrator.educational_project.office.dto.*;
import ru.bellintegrator.educational_project.office.model.Office;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao officeDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfficeDtoForListResponse> getOffices(OfficeDtoForListRequest officeDto) {
        List<Office> offices = officeDao.getOffices(officeDto.getOrgId(), officeDto.getName(), officeDto.getPhone(),
                officeDto.getIsActive());
        return mapperFacade.mapAsList(offices, OfficeDtoForListResponse.class);
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeDtoForSaveResponse getOfficeById(String id) {
        Office office = officeDao.getOfficeById(Integer.parseInt(id));
        return mapperFacade.map(office, OfficeDtoForSaveResponse.class);
    }

    @Override
    @Transactional
    public void updateOffice(OfficeDtoForUpdate officeDto) {
        Office office = officeDao.getOfficeById(officeDto.getId());
        mapperFacade.map(officeDto, office);
    }

    @Override
    @Transactional
    public void addOffice(OfficeDtoForSaveRequest officeDto) {
        Office office = mapperFacade.map(officeDto, Office.class);
        officeDao.save(office);
    }
}
