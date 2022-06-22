package backEnd.demo.service;

import backEnd.demo.repository.EmployeesRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import backEnd.demo.entity.EmployeesApp;
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
    public EmployeesApp saveEmployee(EmployeesApp employees) {
        UserApp userApp = employees.getUser();
              String pw = userApp.getPassword();
                 userApp.setPassword(passwordEncoder.encode(pw));
                 employees.setUser(userApp);
        return employeesRepository.save(employees);
    }

    @Override
    public EmployeesApp showEmployeeByCin(String cin) {
        return employeesRepository.findByCin(cin);
    }


    public EmployeesApp findEmpByUsernaem(String username) {
        return employeesRepository.findByUserUsername(username);
    }


}
