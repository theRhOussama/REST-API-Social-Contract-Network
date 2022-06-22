package backEnd.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class EmployeesApp {
     @Id
     @SequenceGenerator(
             name="user_sequence",
             sequenceName = "emp_sequence",
             allocationSize = 1 )
     @GeneratedValue(
             strategy = GenerationType.SEQUENCE,
             generator = "emp_sequence"
     )
     private  Long idEmp;

     private String nom;
     private  String prenom;
     private  String cin;
     @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

     @OneToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     @JoinColumn(
             name="userId",
             referencedColumnName = "userId"
     )
     private UserApp user;
}
