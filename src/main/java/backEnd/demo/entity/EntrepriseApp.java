package backEnd.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor

@Data
@Builder
public class EntrepriseApp {

    @Id
    @SequenceGenerator(
            name="entreprise_sequence",
            sequenceName = "entreprise_sequence",
            allocationSize = 1 )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "entreprise_sequence"
    )
    private Long id;
    private String siege;
    private String siren;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

    @OneToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name="userId",
            referencedColumnName = "userId"
    )
    private UserApp user;




}
