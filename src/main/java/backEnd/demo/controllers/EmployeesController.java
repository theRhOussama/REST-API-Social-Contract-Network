package backEnd.demo.controllers;

import backEnd.demo.entity.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import backEnd.demo.entity.Employees;
import backEnd.demo.entity.UserApp;
import backEnd.demo.service.AccountService;
import backEnd.demo.service.EmailSenderService;
import backEnd.demo.service.EmployeesService;

import java.util.List;

@RestController

@CrossOrigin(origins = "http://localhost:4200")
public class EmployeesController {


    EmployeesService employeesService;
    AccountService accountService;

	@Autowired
	private EmailSenderService emailSenderService;

    private  String email ;




    public EmployeesController(EmployeesService employeesService, AccountService accountService, EmailSenderService emailSenderService) {
        this.employeesService = employeesService;
        this.accountService = accountService;
        this.emailSenderService = emailSenderService;

    }



    @GetMapping("/getEmployee/{username}")
    public String findEmpByUserName(@PathVariable("username") String username)
    {
            String myemp = employeesService.findEmpByUsernaem(username).getUser().getUsername();
  return myemp;
     }

     @CrossOrigin(origins  ="*")
    @GetMapping("/employee/showCompanies")
    public List<Entreprise> showEntreprise()
     {
         List<Entreprise> entreprises =(List<Entreprise>) employeesService.findCompanies();

         return  entreprises;
     }

    @PostMapping("/register/registerEmployee")

    public Employees registerEmployee(@RequestBody Employees employees)
    {


        UserApp user = employees.getUser();
        String username=  user.getUsername();

        employeesService.saveEmployee(employees);
        accountService.addRoleToUser(username,"EMPLOYEE");
        accountService.addRoleToUser(username,"USER");


		try {
		  emailSenderService.sendSimpleEmail(user.getEmail(),"Bienvenue Mr "+user.getUsername()+" dans la premiere platform Marocaine de gestion des contrats","Bienvenue"  );
		}catch(Exception e) {System.out.print(e.getStackTrace());}



        return employees;
    }



}
