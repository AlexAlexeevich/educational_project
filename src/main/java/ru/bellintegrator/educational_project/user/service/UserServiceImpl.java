package ru.bellintegrator.educational_project.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.educational_project.dictionary.dao.CountryDao;
import ru.bellintegrator.educational_project.dictionary.dao.DocDao;
import ru.bellintegrator.educational_project.dictionary.model.Country;
import ru.bellintegrator.educational_project.dictionary.model.Doc;
import ru.bellintegrator.educational_project.exception.NotFoundElementException;
import ru.bellintegrator.educational_project.mapper.MapperFacade;
import ru.bellintegrator.educational_project.office.dao.OfficeDao;
import ru.bellintegrator.educational_project.user.dao.UserDao;
import ru.bellintegrator.educational_project.user.dto.*;
import ru.bellintegrator.educational_project.user.model.User;
import ru.bellintegrator.educational_project.user.model.UserDoc;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * Поле userDao
     */
    private final UserDao userDao;

    /**
     * Поле countryDao
     */
    private final CountryDao countryDao;

    /**
     * Поле docDao
     */
    private final DocDao docDao;

    /**
     * Поле officeDao
     */
    private final OfficeDao officeDao;

    /**
     * Поле mapperFacade
     */
    private final MapperFacade mapperFacade;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param userDao - объект userDao
     * @param countryDao - объект countryDao
     * @param docDao - объект docDao
     * @param officeDao - объект officeDao
     * @param mapperFacade - объект mapperFacade
     */
    @Autowired
    public UserServiceImpl(UserDao userDao, CountryDao countryDao, DocDao docDao, OfficeDao officeDao, MapperFacade mapperFacade) {
        this.userDao = userDao;
        this.countryDao = countryDao;
        this.docDao = docDao;
        this.officeDao = officeDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserDtoForListResponse> getUsers(UserDtoForListRequest userDto) {
        List<User> users = userDao.getUsers(userDto.getOfficeId(), userDto.getFirstName(), userDto.getLastName(), userDto.getMiddleName(),
                userDto.getPosition(), userDto.getDocCode(), userDto.getCitizenshipCode());
        if (users.isEmpty()) {
            throw new NotFoundElementException("No user");
        }
        return mapperFacade.mapAsList(users, UserDtoForListResponse.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public UserDtoForSaveResponse getUserById(String id) {
        int localId;
        try {
            localId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Input correctly number");
        }
        User user = userDao.getUserById(localId);
        if (user == null) {
            throw new NotFoundElementException("No user");
        }
        return mapperFacade.map(user, UserDtoForSaveResponse.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateUser(UserDtoForUpdate userDto) {
        boolean isExistOffice = officeDao.checkIsExistOffice(userDto.getOfficeId());
        if (isExistOffice) {
            throw new NotFoundElementException("No office");
        }
        User user = userDao.getUserById(userDto.getId());

        if (user == null) {
            throw new NotFoundElementException("No user");
        }

        if (!docDao.existsByName(userDto.getDocName())) {
            throw new NotFoundElementException("No such doc name");
        }
        Doc doc = docDao.findByName(userDto.getDocName());
        UserDoc userDoc = user.getUserDoc();
        userDoc.setDocNumber(userDto.getDocNumber());
        userDoc.setDocDate(userDto.getDocDate());
        userDoc.setDoc(doc);
        user.setUserDoc(userDoc);
        userDoc.setUser(user);

        if (!countryDao.existsByCode(userDto.getCitizenshipCode())) {
            throw new NotFoundElementException("No such citizenship code");
        }
        Country country = countryDao.findByCode(userDto.getCitizenshipCode());
        user.setCountry(country);

        mapperFacade.map(userDto, user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void addUser(UserDtoForSaveRequest userDto) {
        boolean isExistOffice = officeDao.checkIsExistOffice(userDto.getOfficeId());
        if (isExistOffice) {
            throw new NotFoundElementException("No office");
        }

        User user = mapperFacade.map(userDto, User.class);

        if (!docDao.existsByCode(userDto.getDocCode())) {
            throw new NotFoundElementException("No such doc code");
        }
        Doc doc = docDao.findByCode(userDto.getDocCode());
        UserDoc userDoc = new UserDoc(doc, userDto.getDocNumber(), userDto.getDocDate());
        user.setUserDoc(userDoc);
        userDoc.setUser(user);

        if (!countryDao.existsByCode(userDto.getCitizenshipCode())) {
            throw new NotFoundElementException("No such citizenship code");
        }
        Country country = countryDao.findByCode(userDto.getCitizenshipCode());
        user.setCountry(country);

        userDao.save(user);
    }
}
