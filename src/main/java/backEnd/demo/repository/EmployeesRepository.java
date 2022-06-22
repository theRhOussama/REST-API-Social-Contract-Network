package backEnd.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import backEnd.demo.entity.EmployeesApp;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesApp,Long> {


    public  EmployeesApp findByCin(String cin);
    public  EmployeesApp findByUserUsername(String username);



}

