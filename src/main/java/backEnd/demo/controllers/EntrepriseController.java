package backEnd.demo.controllers;

import backEnd.demo.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import backEnd.demo.entity.EntrepriseApp;
import backEnd.demo.entity.UserApp;
import backEnd.demo.service.AccountService;
import backEnd.demo.service.EntrepriseService;
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
    @PostMapping("/register/registerEntreprise")
    public EntrepriseApp registerEntreprise(@RequestBody EntrepriseApp entrepriseApp)
    {

        try{

            UserApp user = entrepriseApp.getUser();
            String username=  user.getUsername();

            entrepriseService.saveEntreprise(entrepriseApp);
            accountService.addRoleToUser(username,"ENTREPRISE");
            accountService.addRoleToUser(username,"USER");
        }catch (Exception e){
         e.printStackTrace();
        }


        return entrepriseApp;
    }



}
