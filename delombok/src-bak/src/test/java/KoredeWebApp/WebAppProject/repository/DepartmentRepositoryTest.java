package KoredeWebApp.WebAppProject.repository;

import KoredeWebApp.WebAppProject.Entity.Department;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
//        Department department = Department.builder()
//                .departmentName("Mechanical Engineering")
//                .departmentAddress("Akoka")
//                .departmentCode("1234")
//                .departmentId(1L)
//                .build();
//
//        testEntityManager.persist(department);
    }


    @Test
    public void saveDepartmentTest(){
        Department department = Department.builder()
                .departmentName("Mechanical Engineering")
                .departmentAddress("Akoka")
                .departmentCode("1234")
                .departmentId(1L)
                .build();

        departmentRepository.save(department);

        Assertions.assertThat(department.getDepartmentId()).isGreaterThan(0);
    }

    @Test
  public void getDepartmentById(){
        Department department = departmentRepository.findById(1L).get();

        if (!department.equals(null)){
            Assertions.assertThat(department.getDepartmentId()).isEqualTo(department);
        }

        Assertions.assertThat(department.getDepartmentId()).isEqualTo(department);
  }
}