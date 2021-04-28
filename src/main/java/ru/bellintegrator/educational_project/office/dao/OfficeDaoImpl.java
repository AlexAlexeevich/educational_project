package ru.bellintegrator.educational_project.office.dao;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.educational_project.office.model.Office;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OfficeDaoImpl implements OfficeDao {

    /**
     * Поле entityManager
     */
    private final EntityManager entityManager;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param entityManager - объект EntityManager
     */
    public OfficeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> getOffices(int orgId, String name, String phone, Boolean isActive) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Office> criteria = builder.createQuery(Office.class);

        Root<Office> root = criteria.from(Office.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(root.get("orgId"), orgId));
        if (name != null) {
            predicates.add(builder.like(root.get("name"), name));
        }
        if (phone != null) {
            predicates.add(builder.like(root.get("phone"), phone));
        }
        if (isActive != null) {
            predicates.add(builder.equal(root.get("isActive"), isActive));
        }
        criteria.multiselect(root.get("id"), root.get("name"),
                root.get("isActive")).where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(criteria).getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office getOfficeById(int id) {
        return entityManager.find(Office.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Office office) {
        entityManager.persist(office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkIsExistOffice(int officeId) {
        Office office = entityManager.find(Office.class, officeId);
        return office == null;
    }
}
