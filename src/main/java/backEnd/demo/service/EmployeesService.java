package backEnd.demo.service;

import backEnd.demo.entity.Employees;
import backEnd.demo.entity.Entreprise;

import java.util.List;

public interface EmployeesService {


    public Employees saveEmployee(Employees employees);
    public Employees showEmployeeByCin(String cin);
    public Employees findEmpByUsernaem(String username);
    public List<Entreprise> findCompanies();


}
