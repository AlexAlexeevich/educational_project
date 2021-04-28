package ru.bellintegrator.educational_project.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.educational_project.exception.NotFoundElementException;
import ru.bellintegrator.educational_project.mapper.MapperFacade;
import ru.bellintegrator.educational_project.office.dao.OfficeDao;
import ru.bellintegrator.educational_project.office.dto.*;
import ru.bellintegrator.educational_project.office.model.Office;
import ru.bellintegrator.educational_project.organization.dao.OrganizationDao;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    /**
     * Поле officeDao
     */
    private final OfficeDao officeDao;

    /**
     * Поле organizationDao
     */
    private final OrganizationDao organizationDao;

    /**
     * Поле mapperFacade
     */
    private final MapperFacade mapperFacade;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param officeDao - объект officeDao
     * @param organizationDao - объект organizationDao
     * @param mapperFacade - объект mapperFacade
     */
    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, OrganizationDao organizationDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao;
        this.organizationDao = organizationDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OfficeDtoForListResponse> getOffices(OfficeDtoForListRequest officeDto) {
        List<Office> offices = officeDao.getOffices(officeDto.getOrgId(), officeDto.getName(), officeDto.getPhone(),
                officeDto.getIsActive());
        if (offices.isEmpty()) {
            throw new NotFoundElementException("No Office");
        }
        return mapperFacade.mapAsList(offices, OfficeDtoForListResponse.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public OfficeDtoForSaveResponse getOfficeById(String id) {
        int localId;
        try {
            localId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Input correctly number");
        }
        Office office = officeDao.getOfficeById(localId);
        if (office == null) {
            throw new NotFoundElementException("No office");
        }
        return mapperFacade.map(office, OfficeDtoForSaveResponse.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateOffice(OfficeDtoForUpdate officeDto) {
        Office office = officeDao.getOfficeById(officeDto.getId());
        if (office == null) {
            throw new NotFoundElementException("No office");
        }
        mapperFacade.map(officeDto, office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void addOffice(OfficeDtoForSaveRequest officeDto) {
        boolean isExistOrganization = organizationDao.checkIsExistOrganization(officeDto.getOrgId());
        if (isExistOrganization) {
            throw new NotFoundElementException("No organization");
        }
        Office office = mapperFacade.map(officeDto, Office.class);
        officeDao.save(office);
    }
}
