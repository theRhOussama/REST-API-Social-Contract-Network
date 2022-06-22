package backEnd.demo.controllers;

import backEnd.demo.entity.Employees;
import backEnd.demo.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import backEnd.demo.entity.Entreprise;
import backEnd.demo.entity.UserApp;
import backEnd.demo.service.AccountService;
import backEnd.demo.service.EntrepriseService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EntrepriseController {
	@Autowired
	private EmailSenderService emailSenderService;
    EntrepriseService entrepriseService;
    AccountService accountService;
    public EntrepriseController(EntrepriseService entrepriseService, AccountService accountService) {
        this.entrepriseService = entrepriseService;
        this.accountService = accountService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/entreprise/showEmployees")
     public List<Employees> showEmployees(){

        List<Employees> employees = entrepriseService.findEmployees();
        return employees;
    }



    @CrossOrigin(origins = "*")
    @PostMapping("/register/registerEntreprise")
    public Entreprise registerEntreprise(@RequestBody Entreprise entreprise)
    {

        try{

            UserApp user = entreprise.getUser();
            String username=  user.getUsername();

            entrepriseService.saveEntreprise(entreprise);
            accountService.addRoleToUser(username,"ENTREPRISE");
            accountService.addRoleToUser(username,"USER");
        }catch (Exception e){
         e.printStackTrace();
        }


        return entreprise;
    }



}
