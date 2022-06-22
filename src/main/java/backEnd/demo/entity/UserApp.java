package backEnd.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UserApp {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId ;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password ;
    private String email;
    private String tel;
    private String pays;
    private String ville;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "image")
	
    private File file;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleApp> roles = new ArrayList<>();

}
