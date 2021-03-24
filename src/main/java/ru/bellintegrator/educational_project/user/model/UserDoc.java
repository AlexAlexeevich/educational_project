package ru.bellintegrator.educational_project.user.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "User_doc")
public class UserDoc {

    @Id
    @Column(name = "Id")
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "doc_id", nullable = false)
    private Integer docId;

    @Column(name = "doc_number", length = 50)
    private String docNumber;

    @Column(name = "doc_date")
    private Date docDate;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    public UserDoc() {
    }

    public UserDoc(Integer docId, String docNumber, Date docDate) {
        this.docId = docId;
        this.docNumber = docNumber;
        this.docDate = docDate;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
