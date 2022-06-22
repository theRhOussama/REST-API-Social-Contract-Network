package backEnd.demo.repository;

import backEnd.demo.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import backEnd.demo.entity.Entreprise;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntrepriseRepository  extends JpaRepository<Entreprise,Long> {
    @Query("SELECT e from Employees e")
     public List<Employees> findAllEmployees();




}
