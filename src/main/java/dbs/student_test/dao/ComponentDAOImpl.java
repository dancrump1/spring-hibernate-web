package dbs.student_test.dao;

import dbs.student_test.entity.Component;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComponentDAOImpl implements ComponentDAO {

    private EntityManager entityManager;

    @Autowired
    public ComponentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save (Component theComponent){
         entityManager.persist(theComponent);
    }


    public Optional<Component> findByTitle(String title) {
        try {
            Component component = entityManager.createQuery(
                            "SELECT c FROM Component c WHERE c.title = :title", Component.class)
                    .setParameter("title", title)
                    .getSingleResult();
            return Optional.of(component);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Component> findAll() {
        return List.of();
    }

    public List<Component> findByCategory(int categoryId) {
        TypedQuery<Component> theQuery = entityManager.createQuery("FROM Components WHERE categories IN :categoryId", Component.class);

        theQuery.setParameter("categoryId", categoryId);

        return theQuery.getResultList();
    }
}
