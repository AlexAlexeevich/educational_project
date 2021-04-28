package ru.bellintegrator.educational_project.organization.dao;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.educational_project.organization.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    /**
     * Поле entityManager
     */
    private final EntityManager entityManager;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param entityManager - объект EntityManager
     */
    public OrganizationDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> getOrganizations(String name, String inn, Boolean isActive) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);

        Root<Organization> root = criteria.from(Organization.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.like(root.get("name"), name));
        if (inn != null) {
            predicates.add(builder.like(root.get("inn"), inn));
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
    public Organization getOrganizationById(int id) {
        return entityManager.find(Organization.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Organization organization) {
        entityManager.persist(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkIsExistOrganization(int orgId) {
        Organization organization = entityManager.find(Organization.class, orgId);
        return organization == null;
    }
}
