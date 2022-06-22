package backEnd.demo.service;

import backEnd.demo.repository.EmployeesRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import backEnd.demo.entity.Employees;
import backEnd.demo.entity.UserApp;

import javax.transaction.Transactional;

@Transactional

@Service
public class EmployeeServiceImpl implements EmployeesService {

    public EmployeeServiceImpl(EmployeesRepository employeesRepository, PasswordEncoder passwordEncoder) {
        this.employeesRepository = employeesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private EmployeesRepository employeesRepository;
    private PasswordEncoder passwordEncoder;




    @Override
    public Employees saveEmployee(Employees employees) {
        UserApp userApp = employees.getUser();
              String pw = userApp.getPassword();
                 userApp.setPassword(passwordEncoder.encode(pw));
                 employees.setUser(userApp);
        return employeesRepository.save(employees);
    }

    @Override
    public Employees showEmployeeByCin(String cin) {
        return employeesRepository.findByCin(cin);
    }


    public Employees findEmpByUsernaem(String username) {
        return employeesRepository.findByUserUsername(username);
    }


}
