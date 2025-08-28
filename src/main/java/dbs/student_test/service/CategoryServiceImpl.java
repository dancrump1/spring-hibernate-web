package dbs.student_test.service;

import dbs.student_test.dao.CategoryDAO;
import dbs.student_test.entity.Category;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryServiceImpl {

    private CategoryDAO categoryDAO;

    @Autowired
    CategoryServiceImpl(CategoryDAO theCategoryoDAO) {
        categoryDAO = theCategoryoDAO;
    }

    @Transactional
    public Category findByTitle(String theTitle) {
        return categoryDAO.findByTitle(theTitle);
    }

    @Transactional
    public Category findById(int theId) {
        return categoryDAO.findById(theId);
    }

    @Transactional
    public List<Category> findAll(){
        return categoryDAO.findAll();
    }

    @Transactional
    public void save(Category patchedCategory) {
        categoryDAO.save(patchedCategory);
        return;
    }
}
