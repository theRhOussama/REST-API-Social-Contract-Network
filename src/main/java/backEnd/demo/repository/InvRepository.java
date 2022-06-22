package backEnd.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import backEnd.demo.entity.Employees;
import backEnd.demo.entity.Entreprise;
import backEnd.demo.entity.Invitation;
@Repository
public interface InvRepository extends JpaRepository<Invitation, Long>{
	List<Invitation> findByEmploye(Employees employe);
	List<Invitation> findByEntreprise(Entreprise entreprise);

}
