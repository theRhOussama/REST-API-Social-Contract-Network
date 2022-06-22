package backEnd.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import backEnd.demo.repository.EmployeesRepository;
import backEnd.demo.repository.EntrepriseRepository;
import backEnd.demo.repository.InvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import backEnd.demo.entity.EmployeesApp;
import backEnd.demo.entity.EntrepriseApp;
import backEnd.demo.entity.Invitation;
import backEnd.demo.entity.contrat;


@Service
public class InvServiceImplem implements InvService{
	 @Autowired
	    private EntrepriseRepository entrepriseRepository ;
	  @Autowired
	    private EmployeesRepository employeRepository;
	  @Autowired
	  private InvRepository invRepository;
	  @Autowired
	  private ContratService contratService;

	@Override
	public List<Invitation> ListerInvitationent(long iden) {
		List<Invitation> invitations;
		EntrepriseApp entreprise =entrepriseRepository.findById(iden).get();
		invitations=invRepository.findByEntreprise(entreprise);
		
		return invitations;
	}

	@Override
	public List<Invitation> ListerInvitationem(long idem) {
		// TODO Auto-generated method stub
		List<Invitation> invitations;
		EmployeesApp employe =employeRepository.findById(idem).get();
		invitations=invRepository.findByEmploye(employe);
		
		return invitations;
	}

	
	

	@Override
	public Invitation inviter(long ide,long idem,MultipartFile file,String type, LocalDate date_debut, LocalDate date_fin)throws Exception {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		contrat c=contratService.saveContrat(file, type, date_debut, date_fin);
		Invitation invitation= new Invitation();
		EmployeesApp employe= employeRepository.findById(idem).get();
		EntrepriseApp entreprise=entrepriseRepository.findById(idem).get();
		invitation.setEntreprise(entreprise);
		invitation.setEmploye(employe);
		invitation.setContrat(c);
		invitation.setDate(LocalDateTime.now());
		
		// TODO Auto-generated method stub
		invRepository.save(invitation);
		return invitation;
	}

	@Override
	public Invitation accepter(Invitation invitation) {
		// TODO Auto-generated method stub
		return invRepository.save(invitation);
		
	}

}
