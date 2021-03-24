package ru.bellintegrator.educational_project.dictionary.model;

import ru.bellintegrator.educational_project.user.model.UserDoc;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doc")
public class Doc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "code", length = 2)
    private String code;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "doc_id")
    private List<UserDoc> userDocs;

    public Doc() {
    }

    public Doc(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<UserDoc> getUserDocs() {
        return userDocs;
    }

    public void setUserDocs(List<UserDoc> userDocs) {
        this.userDocs = userDocs;
    }
}
