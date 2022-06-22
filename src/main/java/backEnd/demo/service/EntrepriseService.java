package backEnd.demo.service;

import backEnd.demo.entity.Employees;
import backEnd.demo.entity.Entreprise;

import java.util.List;

public interface EntrepriseService {
    public Entreprise saveEntreprise(Entreprise entreprise);
    public Entreprise findByUserName(String entrepriseApp);
    public List<Employees> findEmployees();

}
