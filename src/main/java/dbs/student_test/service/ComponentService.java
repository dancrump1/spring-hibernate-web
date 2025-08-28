package dbs.student_test.service;

import dbs.student_test.entity.Component;

import java.util.List;

public interface ComponentService {

    List<Component> findAll();

    Component findByTitle(String var1);

    List<Component> findByCategory(String var1);
}
