package backEnd.demo.service;

import backEnd.demo.entity.Employees;

public interface EmployeesService {


    public Employees saveEmployee(Employees employees);
    public Employees showEmployeeByCin(String cin);
    public Employees findEmpByUsernaem(String username);


}
