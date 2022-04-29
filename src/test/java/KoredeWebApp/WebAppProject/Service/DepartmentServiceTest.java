//package KoredeWebApp.WebAppProject.Service;
//
//import KoredeWebApp.WebAppProject.Entity.Department;
//import KoredeWebApp.WebAppProject.repository.DepartmentRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.stereotype.Service;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class DepartmentServiceTest {
//
//    @Autowired
//    private DepartmentService departmentService;
//
//    @MockBean
//    private DepartmentRepository departmentRepository;
//
//    @BeforeEach
//    void setUp() {
//        Department department = Department.builder()
//                .departmentName("IT")
//                .departmentAddress("F407")
//                .departmentCode("1234")
//                .departmentId(1L)
//                .build();
//
//        Mockito.when(departmentRepository.findByDepartmentIgnoreCase("IT"))
//                .thenReturn(department);
//    }
//
//    @Test
//    public void whenValidDepartmentName_thenDepartmentNameShouldFound(){
//        String departmentName = "IT";
//        Department found = departmentService.getDepartmentByName(departmentName);
//        assertEquals(departmentName,found.getDepartmentName());
//    }
//}