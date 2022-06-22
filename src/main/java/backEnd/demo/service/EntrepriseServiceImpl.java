package backEnd.demo.service;

import backEnd.demo.repository.EntrepriseRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import backEnd.demo.entity.EntrepriseApp;
import backEnd.demo.entity.UserApp;

@Service
public class EntrepriseServiceImpl implements  EntrepriseService {

    public EntrepriseServiceImpl(PasswordEncoder passwordEncoder, EntrepriseRepository entrepriseRepository) {
        this.passwordEncoder = passwordEncoder;
        this.entrepriseRepository = entrepriseRepository;
    }

    PasswordEncoder passwordEncoder ;

    EntrepriseRepository entrepriseRepository;

    @Override
    public EntrepriseApp saveEntreprise(EntrepriseApp entrepriseApp) {
        UserApp userApp = entrepriseApp.getUser();
        String pw = userApp.getPassword();
        userApp.setPassword(passwordEncoder.encode(pw));
     entrepriseApp.setUser(userApp);
        return entrepriseRepository.save(entrepriseApp);
    }

    @Override
    public EntrepriseApp findByUserName(String entrepriseApp) {
        return entrepriseRepository.findByUserUsername(entrepriseApp);
    }
}
