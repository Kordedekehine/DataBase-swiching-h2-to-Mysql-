package KoredeWebApp.WebAppProject.Service;

import KoredeWebApp.WebAppProject.Entity.Department;
import KoredeWebApp.WebAppProject.ErrorHandler.DepartmentNotFoundException;


import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department) ;

    List<Department> getDepartmentList() throws DepartmentNotFoundException ;

    Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

   public void deleteDepartmentById(Long departmentId) ;

   public Department updateDepartment(Long departmentId, Department department);

   public Department getDepartmentByName(String departmentName) throws DepartmentNotFoundException;

//   public  Department findByDepartmentNameIgnoreCase(String departmentName);


}
