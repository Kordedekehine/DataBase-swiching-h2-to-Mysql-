package KoredeWebApp.WebAppProject.Service;

import KoredeWebApp.WebAppProject.Entity.Department;
import KoredeWebApp.WebAppProject.ErrorHandler.DepartmentNotFoundException;
import KoredeWebApp.WebAppProject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);

    }


    @Override
    public List<Department> getDepartmentList() throws DepartmentNotFoundException {
        //return departmentRepository.findAll();
        List<Department> getAllList = departmentRepository.findAll();
        if (getAllList.isEmpty()) {
            throw new DepartmentNotFoundException("DATABASE IS EMPTY");
        }
        return getAllList;
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        //return departmentRepository.findById(departmentId).get();

        Optional<Department> department = departmentRepository.findById(departmentId);

        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("ERROR! CHECK DATABASE IF EMPTY");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }


    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department getDepartmentByName(String departmentName) throws DepartmentNotFoundException {
        // return departmentRepository.findByDepartmentName(departmentName);

        Optional<Department> findName = Optional.ofNullable(departmentRepository.findByDepartmentName(departmentName));

        if (!findName.isPresent()) {
            throw new DepartmentNotFoundException("CANNOT FIND NAME");
        }

        return findName.get();
    }
}

//    @Override
//    public Department findByDepartmentNameIgnoreCase(String departmentName) {
//        return departmentRepository.findByDepartmentIgnoreCase(departmentName);
//    }

