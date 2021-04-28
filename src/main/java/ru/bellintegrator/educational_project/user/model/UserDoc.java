package ru.bellintegrator.educational_project.user.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bellintegrator.educational_project.dictionary.model.Doc;

import javax.persistence.*;
import java.sql.Date;

/**
 * Entity-класс для личного документа работника
 */
@Data
@Entity
@Table(name = "User_doc")
@NoArgsConstructor
public class UserDoc {

    /**
     * Поле id
     */
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * Служебное поле version (для Hibernate).
     */
    @Version
    private Integer version;

    /**
     * Поле номер документа
     */
    @Column(name = "doc_number", length = 50)
    private String docNumber;

    /**
     * Поле дата документа
     */
    @Column(name = "doc_date")
    private Date docDate;

    /**
     * Поле работник
     */
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    /**
     * Поле документ
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id")
    private Doc doc;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param docNumber - номер
     * @param docDate - дата
     */
    public UserDoc(String docNumber, Date docDate) {
        this.docNumber = docNumber;
        this.docDate = docDate;
    }

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param docNumber - номер
     * @param docDate - дата
     */
    public UserDoc(Doc doc, String docNumber, Date docDate) {
        this.doc = doc;
        this.docNumber = docNumber;
        this.docDate = docDate;
    }
}
