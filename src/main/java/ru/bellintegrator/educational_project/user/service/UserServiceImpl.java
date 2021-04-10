package ru.bellintegrator.educational_project.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.educational_project.dictionary.dao.CountryDao;
import ru.bellintegrator.educational_project.dictionary.dao.DocDao;
import ru.bellintegrator.educational_project.dictionary.model.Country;
import ru.bellintegrator.educational_project.dictionary.model.Doc;
import ru.bellintegrator.educational_project.mapper.MapperFacade;
import ru.bellintegrator.educational_project.user.dao.UserDao;
import ru.bellintegrator.educational_project.user.dto.*;
import ru.bellintegrator.educational_project.user.model.User;
import ru.bellintegrator.educational_project.user.model.UserDoc;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final CountryDao countryDao;
    private final DocDao docDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public UserServiceImpl(UserDao userDao, CountryDao countryDao, DocDao docDao, MapperFacade mapperFacade) {
        this.userDao = userDao;
        this.countryDao = countryDao;
        this.docDao = docDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDtoForListResponse> getUsers(UserDtoForListRequest userDto) {
        List<User> users = userDao.getUsers(userDto.getOfficeId(), userDto.getFirstName(), userDto.getLastName(), userDto.getMiddleName(),
                userDto.getPosition(), userDto.getDocCode(), userDto.getCitizenshipCode());
        return mapperFacade.mapAsList(users, UserDtoForListResponse.class);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDtoForSaveResponse getUserById(String id) {
        User user = userDao.getUserById(Integer.parseInt(id));
        return mapperFacade.map(user, UserDtoForSaveResponse.class);
    }

    @Override
    @Transactional
    public void updateUser(UserDtoForUpdate userDto) {
        User user = userDao.getUserById(userDto.getId());
        mapperFacade.map(userDto, user);

        if(userDto.getDocName() != null) {
            Doc doc = docDao.findByName(userDto.getDocName());
            UserDoc userDoc = user.getUserDoc();
            userDoc.setDocNumber(userDto.getDocNumber());
            userDoc.setDocDate(userDto.getDocDate());
            userDoc.setDoc(doc);
            user.setUserDoc(userDoc);
            userDoc.setUser(user);
        }

        if(userDto.getCitizenshipCode() != null) {
            Country country = countryDao.findByCode(userDto.getCitizenshipCode());
            user.setCountry(country);
        }
    }

    @Override
    @Transactional
    public void addUser(UserDtoForSaveRequest userDto) {
        User user = mapperFacade.map(userDto, User.class);

        if(userDto.getDocCode() != null) {
            Doc doc = docDao.findByCode(userDto.getDocCode());
            UserDoc userDoc = new UserDoc(doc, userDto.getDocNumber(), userDto.getDocDate());
            user.setUserDoc(userDoc);
            userDoc.setUser(user);
        }
        if(userDto.getCitizenshipCode() != null) {
            Country country = countryDao.findByCode(userDto.getCitizenshipCode());
            user.setCountry(country);
        }

        userDao.save(user);
    }


}
