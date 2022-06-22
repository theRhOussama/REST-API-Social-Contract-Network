package backEnd.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import backEnd.demo.entity.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Long> {


    public Employees findByCin(String cin);
    public Employees findByUserUsername(String username);



}

