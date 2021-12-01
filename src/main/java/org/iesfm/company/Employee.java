package org.iesfm.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    private String nif;
    private String name;
    private String surname;
    private String role;
    @Column(name = "department_name")
    private String departmentName;

    public Employee(String nif, String name, String surname, String role, String departmentName) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.departmentName = departmentName;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(nif, employee.nif) && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(role, employee.role) && Objects.equals(departmentName, employee.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, surname, role, departmentName);
    }
}
