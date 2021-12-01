package org.iesfm.company;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Department {

    @Id
    private String name;
    private String description;

    @JsonCreator
    public Department(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description
    ) {
        this.name = name;
        this.description = description;
    }

    public Department() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department company = (Department) o;
        return Objects.equals(name, company.name) && Objects.equals(description, company.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}
