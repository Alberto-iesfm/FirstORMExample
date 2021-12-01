package org.iesfm.company.repository;

import org.iesfm.company.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {


    List<Department> findByDescription(String description);

    @Query(
            value = "SELECT d.* FROM Employee e INNER JOIN Department d ON d.name=e.department_name GROUP BY e.department_name HAVING count(*) = 2",
            nativeQuery = true)
    List<Department> findDepartmentsWithTwoEmployees();
}
