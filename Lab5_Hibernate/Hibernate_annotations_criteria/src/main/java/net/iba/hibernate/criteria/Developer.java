package net.iba.hibernate.criteria;

import javax.persistence.*;

@Entity
@Table(name = "HIBERNATE_DEVELOPERS")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "SPECIALTY")
    private String specialty;

    @Column(name = "EXPERIENCE")
    private int experience;

    @Column(name = "SALARY")
    private Integer salary; // Тип поля изменен на объектный Integer

    public Developer() {
    }

    public Developer(String firstName, String lastName, String specialty, int experience, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.experience = experience;
        this.salary = salary;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", experience=" + experience +
                ", salary=" + (salary != null ? salary : "Not Specified") + // Добавлено, чтобы обработать возможное null
                '}';
    }
}
