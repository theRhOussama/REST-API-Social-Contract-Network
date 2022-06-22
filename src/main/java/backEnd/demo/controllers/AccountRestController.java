package backEnd.demo.controllers;

import lombok.Data;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import backEnd.demo.entity.RoleApp;
import backEnd.demo.entity.UserApp;
import backEnd.demo.service.AccountService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "true")
@RestController
public class AccountRestController {


    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("/users")
    public List<UserApp> appUsers(){
    return
            accountService.listUsers();
    }
    @PostMapping("/addUser")
    public UserApp saveUser(@Nullable@RequestParam(name = "files" ,required =false ) MultipartFile file ,@RequestBody UserApp userApp) throws Exception{
        return accountService.addNewUser(file,userApp);
    }
    @PostMapping("/addRole")
    public RoleApp saveRole(@RequestBody RoleApp roleApp){

        return accountService.addNewRole(roleApp);
    }
    @PostMapping("/addRoleToUser")
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
         accountService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getRoleName());
    }



}
@Data
class RoleUserForm{
    private String username;
    private String roleName;
}
