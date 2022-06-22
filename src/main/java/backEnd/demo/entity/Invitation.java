package backEnd.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Invitation {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employe_id",nullable = true, foreignKey = @ForeignKey(name="FK_EMPLOYE"))
	
	private Employees employe;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "entreprise_id",nullable = true, foreignKey = @ForeignKey(name="FK_ENTREPRISE"))
	
	private Entreprise entreprise;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contrat_id",nullable = false, foreignKey = @ForeignKey(name="FK_CONTRAT"))
	
	private contrat contrat;
	private boolean accepted= false;
	private LocalDateTime date;
	
	
}
