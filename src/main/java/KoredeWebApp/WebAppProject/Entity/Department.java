package KoredeWebApp.WebAppProject.Entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data //This includes all the getters and setters,hashcode,requiredArgsConstructor so there is no need for it
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Please add Department name") //we use  hibernate validator for this to emphasize name input
    @Length(max = 8,min = 1)
    @Size(max = 10,min = 1)
    //And so on
    private String departmentName;

    private String departmentAddress;
    private String departmentCode;

}
