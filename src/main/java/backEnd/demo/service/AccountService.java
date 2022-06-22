package backEnd.demo.service;

import backEnd.demo.entity.RoleApp;
import backEnd.demo.entity.UserApp;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface AccountService {
     UserApp addNewUser(MultipartFile file,UserApp userapp)throws Exception;
     RoleApp addNewRole(RoleApp approle);
     void addRoleToUser(String username , String role);
     UserApp loadUserByUserName(String username);
     List<UserApp> listUsers();
     RoleApp findRoleByRoleName(String roleName);
}
