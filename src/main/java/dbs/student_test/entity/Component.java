package dbs.student_test.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "components")
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "categories", columnDefinition = "VARCHAR(255)")
    private String categories;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories.toString();
    }
}
