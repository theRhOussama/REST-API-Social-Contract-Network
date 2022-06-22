package backEnd.demo.service;

import backEnd.demo.entity.EntrepriseApp;

public interface EntrepriseService {
    public EntrepriseApp saveEntreprise(EntrepriseApp entrepriseApp);
    public EntrepriseApp findByUserName(String entrepriseApp);

}
