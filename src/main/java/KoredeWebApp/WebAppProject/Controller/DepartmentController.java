package KoredeWebApp.WebAppProject.Controller;

import KoredeWebApp.WebAppProject.Entity.Department;
import KoredeWebApp.WebAppProject.Service.DepartmentService;
import KoredeWebApp.WebAppProject.Service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){ //We also add validations here
        //It will be validated if and only if name is not empty
      //  DepartmentService service = new DepartmentServiceImpl(); We don't wanna go this way,we autowire
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartmentList(){
        return departmentService.getDepartmenList();
    }

    @GetMapping(path = "/departments/{departmentId}")
    public Department getDepartmentById(@PathVariable Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{departmentId}")
    public String deleteDepartmentById(@PathVariable Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Successfully deletes department";
    }

    @PutMapping("/departments/{departmentId}")
    public Department updateDepartment(@PathVariable Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }


}
