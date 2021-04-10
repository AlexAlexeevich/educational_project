package ru.bellintegrator.educational_project.user.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bellintegrator.educational_project.dictionary.model.Country;

import javax.persistence.*;

@Data
@Entity
@Table(name = "User")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "second_name", length = 100, nullable = false)
    private String secondName;

    @Column(name = "middle_name", length = 100, nullable = false)
    private String middleName;

    @Column(name = "phone", length = 25)
    private String phone;

    @Column(name = "position", length = 50, nullable = false)
    private String position;

    @Column(name = "is_identified")
    private Boolean isIdentified;

    @Column(name = "office_id", nullable = false)
    private Integer officeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizenship_id")
    private Country country;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserDoc userDoc;

    public User(Integer id, String firstName, String secondName, String middleName, String position)
    {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
    }

    public User(Integer id, String firstName, String secondName, String middleName, String position, Boolean isIdentified,
                UserDoc userDoc, Country country ) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.isIdentified = isIdentified;
        this.country = country;
        this.userDoc = userDoc;
    }

    public Boolean getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(Boolean identified) {
        isIdentified = identified;
    }
}
