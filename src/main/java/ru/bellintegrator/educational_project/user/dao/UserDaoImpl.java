package ru.bellintegrator.educational_project.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.educational_project.office.model.Office;
import ru.bellintegrator.educational_project.user.model.User;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getUsers(Integer officeId, String firstName, String lastName, String middleName, String position,
                               String docCode, String citizenshipCode) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);

        Root<User> root = criteria.from(User.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(root.get("officeId"), officeId));
        if (firstName != null) {
            predicates.add(builder.like(root.get("firstName"), firstName));
        }
        if (lastName != null) {
            predicates.add(builder.equal(root.get("secondName"), lastName));
        }
        if (middleName != null) {
            predicates.add(builder.equal(root.get("middleName"), middleName));
        }
        if (position != null) {
            predicates.add(builder.equal(root.get("position"), position));
        }
        if (docCode != null) {
            predicates.add(builder.equal(root.get("userDoc").get("doc").get("code"), docCode));
        }
        if (citizenshipCode != null) {
            predicates.add(builder.equal(root.get("country").get("code"), citizenshipCode));
        }

        criteria.multiselect(root.get("id"), root.get("firstName"), root.get("secondName"), root.get("middleName"),
                root.get("position")).where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public boolean checkIsExistOffice(int officeId) {
        Office office = entityManager.find(Office.class, officeId);
        return office == null;
    }
}
