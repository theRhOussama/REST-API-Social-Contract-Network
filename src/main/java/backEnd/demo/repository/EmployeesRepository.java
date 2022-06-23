package backEnd.demo.repository;

import backEnd.demo.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import backEnd.demo.entity.Employees;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Long> {


    public Employees findByCin(String cin);
    public Employees findByUserUsername(String username);

    @Query("SELECT e from Entreprise e")
    public List<Entreprise> findAllCompanies();



}

