package dbs.student_test.service;

import dbs.student_test.dao.ComponentDAO;
import dbs.student_test.entity.Component;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComponentServiceImpl {

    private ComponentDAO componentDAO;

    @Autowired
    public ComponentServiceImpl(ComponentDAO theComponentDAO) {
        componentDAO = theComponentDAO;
    }

    @Transactional
    public Component findByTitle(String theName) {
        return componentDAO.findByTitle(theName);
    }

    @Transactional
    public List<Component> findByCategory(int theCategory) {
        return componentDAO.findByCategory(theCategory);
    }

    @Transactional
    public List<Component> findAll() {
        return componentDAO.findAll();
    }
}
