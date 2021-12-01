package org.iesfm.company.controller;

import org.iesfm.company.Department;
import org.iesfm.company.repository.DepartmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class DepartmentController {

    private DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/departments")
    public void createDepartment(@RequestBody Department department) {
        departmentRepository.save(department);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/departments")
    public List<Department> list(
            @RequestParam(value = "description", required = false) String description
    ) {
        if (description == null) {
            return departmentRepository.findAll();
        } else {
            return departmentRepository.findByDescription(description);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/departments/{departmentName}")
    public Department get(@PathVariable("departmentName") String name) {
        return departmentRepository
                .findById(name)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento no encontrado")
                );
    }


    @RequestMapping(method = RequestMethod.DELETE, path = "/departments/{departmentName}")
    public void delete(@PathVariable("departmentName") String name) {
        departmentRepository.deleteById(name);
    }

}
