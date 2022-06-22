package backEnd.demo.service;

import backEnd.demo.entity.EmployeesApp;

public interface EmployeesService {


    public EmployeesApp saveEmployee(EmployeesApp employees);
    public EmployeesApp showEmployeeByCin(String cin);
    public EmployeesApp findEmpByUsernaem(String username);


}
