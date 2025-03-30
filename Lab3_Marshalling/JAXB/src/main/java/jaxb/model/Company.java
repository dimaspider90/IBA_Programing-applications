package jaxb.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)

public class Company {
    private String compNo;
    private String compName;

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    private List<Department> departments;

    /**
     * This default constructor is required if there are other constructors.
     */
    public Company() {

    }

    public Company(String compNo, String compName) {
        this.compNo = compNo;
        this.compName = compName;

    }
    public String getCompNo() {
        return compNo;
    }
    public void setCompNo(String compNo) {
        this.compNo = compNo;
    }

    public String getDeptName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = this.compName;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
