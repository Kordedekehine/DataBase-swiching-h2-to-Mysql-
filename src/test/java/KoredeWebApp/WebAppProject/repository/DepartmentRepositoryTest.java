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
Department department = new Department();
department.setDepartmentId(1L);
department.setDepartmentName("Mechanical Engineering");
department.setDepartmentAddress("Akoka");
department.setDepartmentCode("532");

        testEntityManager.persist(department);
    }


    @Test
    public void saveDepartmentTest(){
        Department department = new Department();
        department.setDepartmentId(1L);
        department.setDepartmentName("Mechanical Engineering");
        department.setDepartmentAddress("Akoka");
        department.setDepartmentCode("532");

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