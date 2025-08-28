package dbs.student_test.dao;

import dbs.student_test.entity.Category;
import dbs.student_test.entity.Component;
import dbs.student_test.rest.ComponentNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    private EntityManager entityManager;

    @Autowired
    public CategoryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Category var1) {
        entityManager.merge(var1);
    }

    @Override
    public Category findById(Integer var1) {
        try {
            return entityManager.createQuery("SELECT c FROM Category c WHERE c.id = :var1", Category.class).setParameter("var1", var1).getSingleResult();
        } catch (NoResultException e) {
            throw new ComponentNotFoundException("Failed to search for component: " + var1);
        }
    }

    @Override
    public List<Category> findAll() {
        return entityManager.createQuery(
                        "SELECT c FROM Category c", Category.class)
                .getResultList();
    }

    @Override
    public Category findByTitle(String var1) {
        TypedQuery<Category> theQuery = entityManager.createQuery("FROM Category WHERE title = :var1", Category.class);

        theQuery.setParameter("var1", var1);

        return theQuery.getSingleResult();
    }
}
