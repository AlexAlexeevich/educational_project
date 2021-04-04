package ru.bellintegrator.educational_project.user.model;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "middle_name", length = 100, nullable = false)
    private String middleName;

    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @Column(name = "phone", length = 25)
    private String phone;

    @Column(name = "position", length = 50, nullable = false)
    private String position;

    @Column(name = "is_identified")
    private String isIdentified;

    @Column(name = "office_id", nullable = false)
    private Integer officeId;

    @Column(name = "citizenship_id", nullable = false)
    private Integer citizenshipId;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserDoc userDoc;

    public User() {
    }

    public User(String firstName, String lastName, String middleName, String address, String phone, String position,
                String isIdentified, Integer officeId, Integer citizenshipId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.address = address;
        this.phone = phone;
        this.position = position;
        this.isIdentified = isIdentified;
        this.officeId = officeId;
        this.citizenshipId = citizenshipId;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(String isIdentified) {
        this.isIdentified = isIdentified;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public Integer getCitizenshipId() {
        return citizenshipId;
    }

    public void setCitizenshipId(Integer citizenshipId) {
        this.citizenshipId = citizenshipId;
    }

    public UserDoc getUserDoc() {
        return userDoc;
    }

    public void setUserDoc(UserDoc userDoc) {
        this.userDoc = userDoc;
    }
}
