package ru.bellintegrator.educational_project.user.dao;

import ru.bellintegrator.educational_project.user.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers(Integer officeId, String firstName, String lastName, String middleName,
                       String position, String docCode, String citizenshipCode);

    User getUserById(int id);

    void save(User user);

    boolean checkIsExistOffice(int officeId);
}
