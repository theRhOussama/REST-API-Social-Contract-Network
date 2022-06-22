package backEnd.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import backEnd.demo.entity.EmployeesApp;
import backEnd.demo.entity.EntrepriseApp;
import backEnd.demo.entity.Invitation;
@Repository
public interface InvRepository extends JpaRepository<Invitation, Long>{
	List<Invitation> findByEmploye(EmployeesApp employe);
	List<Invitation> findByEntreprise(EntrepriseApp entreprise);

}
