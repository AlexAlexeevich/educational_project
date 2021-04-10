package ru.bellintegrator.educational_project.user.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bellintegrator.educational_project.dictionary.model.Doc;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "User_doc")
@NoArgsConstructor
public class UserDoc {

    @Id
    @Column(name = "Id")
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "doc_number", length = 50)
    private String docNumber;

    @Column(name = "doc_date")
    private Date docDate;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id")
    private Doc doc;

    public UserDoc(String docNumber, Date docDate) {
        this.docNumber = docNumber;
        this.docDate = docDate;
    }

    public UserDoc(Doc doc, String docNumber, Date docDate) {
        this.doc = doc;
        this.docNumber = docNumber;
        this.docDate = docDate;

    }
}
