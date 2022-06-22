package backEnd.demo.service;

import backEnd.demo.repository.FileRepository;
import backEnd.demo.repository.RoleAppRepository;
import backEnd.demo.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import backEnd.demo.entity.File;
import backEnd.demo.entity.RoleApp;
import backEnd.demo.entity.UserApp;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {


    public AccountServiceImpl(UserAppRepository userAppRepository, RoleAppRepository roleAppRepository, PasswordEncoder passwordEncoder) {
        this.userAppRepository = userAppRepository;
        this.roleAppRepository = roleAppRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private UserAppRepository userAppRepository;

    private RoleAppRepository roleAppRepository;

    private PasswordEncoder passwordEncoder;
	@Autowired
	private FileRepository fileRepository;
	@Autowired
	private FileService fileService;
    @Override
    public UserApp addNewUser(@Nullable MultipartFile file,UserApp userapp) throws Exception {
    File f= fileService.saveAttachment(file);
	      
		// TODO Auto-generated method stub
	              if(f!=null) {
        String pw = userapp.getPassword();
        userapp.setPassword(passwordEncoder.encode(pw));
        userapp.setFile(f);
        return   userAppRepository.save(userapp);}
	              return null;
    }

    @Override
    public RoleApp addNewRole(RoleApp approle) {

        return roleAppRepository.save(approle);
    }


    @Override
    public void addRoleToUser(String username, String role) {

            UserApp userApp = userAppRepository.findByUsername(username);
            RoleApp roleApp = roleAppRepository.findByRoleName(role);
            userApp.getRoles().add(roleApp);



    }

    @Override
    public UserApp loadUserByUserName(String username) {
       return userAppRepository.findByUsername(username);
    }

    @Override
    public List<UserApp> listUsers() {
        return  userAppRepository.findAll();
    }

    @Override
    public RoleApp findRoleByRoleName(String roleName) {
        return  roleAppRepository.findByRoleName(roleName);
    }
}
