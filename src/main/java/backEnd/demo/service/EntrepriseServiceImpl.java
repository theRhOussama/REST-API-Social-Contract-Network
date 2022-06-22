package backEnd.demo.service;

import backEnd.demo.entity.Employees;
import backEnd.demo.repository.EntrepriseRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import backEnd.demo.entity.Entreprise;
import backEnd.demo.entity.UserApp;

import java.util.List;

@Service
public class EntrepriseServiceImpl implements  EntrepriseService {

    public EntrepriseServiceImpl(PasswordEncoder passwordEncoder, EntrepriseRepository entrepriseRepository) {
        this.passwordEncoder = passwordEncoder;
        this.entrepriseRepository = entrepriseRepository;
    }

    PasswordEncoder passwordEncoder ;

    EntrepriseRepository entrepriseRepository;

    @Override
    public Entreprise saveEntreprise(Entreprise entreprise) {
        UserApp userApp = entreprise.getUser();
        String pw = userApp.getPassword();
        userApp.setPassword(passwordEncoder.encode(pw));
     entreprise.setUser(userApp);
        return entrepriseRepository.save(entreprise);
    }


    @Override
    public Entreprise findByUserName(String entrepriseApp) {
        return null;
    }

    @Override
    public List<Employees> findEmployees() {
        return  entrepriseRepository.findAllEmployees();
    }
}
