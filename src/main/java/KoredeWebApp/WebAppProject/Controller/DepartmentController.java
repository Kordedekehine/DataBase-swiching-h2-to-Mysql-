package KoredeWebApp.WebAppProject.Controller;

import KoredeWebApp.WebAppProject.Entity.Department;
import KoredeWebApp.WebAppProject.ErrorHandler.DepartmentNotFoundException;
import KoredeWebApp.WebAppProject.Service.DepartmentService;
import KoredeWebApp.WebAppProject.Service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department){ //We also add validations here
        //It will be validated if and only if name is not empty
      LOGGER.info("save department message inside the controller class");//Pop up message any time we want to log on the method
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/department")
    public List<Department> getDepartmentList() throws DepartmentNotFoundException {
        return departmentService.getDepartmentList();
    }

    @GetMapping(path = "/department/{departmentId}")
    public Department getDepartmentById(@PathVariable Long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/department/{departmentId}")
    public String deleteDepartmentById(@PathVariable Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Successfully deletes department";
    }

    @PutMapping("/department/{departmentId}")
    public Department updateDepartment(@PathVariable Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/department/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName) throws DepartmentNotFoundException {
        return departmentService.getDepartmentByName(departmentName);
    }


}
