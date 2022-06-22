package backEnd.demo.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import backEnd.demo.entity.Invitation;
import backEnd.demo.repository.InvRepository;
import backEnd.demo.service.EmailSenderService;
import backEnd.demo.service.InvService;

@RestController
public class InvitationController {
	@Autowired
	private InvService invService;
	@Autowired
	private InvRepository invRepository;
	@Autowired
	private EmailSenderService emailSenderService;
	@PostMapping("/inviter/{iden}/{idem}")
	public String inviter(@PathVariable long iden,@PathVariable long idem ,@RequestParam("file")MultipartFile file,@RequestParam(name = "type") String type,@Nullable@RequestParam(name = "date_debut") LocalDate date_debut,@Nullable@RequestParam(name = "date_fin") LocalDate date_fin,final HttpServletRequest request)throws Exception 
	{	
		Invitation invitation= invService.inviter(iden, idem,file,type,date_debut,date_fin);
		try {
			emailSenderService.sendSimpleEmail(invitation.getEmploye().getUser().getEmail().toString(),"Bonjour cher utilisateur "+ invitation.getEmploye().getNom()+" "+invitation.getEmploye().getPrenom() +" veulliez consulter votre compte ,car il y a une nouvelle contrat a valider voila l'identifiant du contrat "+invitation.getContrat().getId()+" et Merci","Nouvelle contrat : "+invitation.getContrat().getType() );
			}catch(Exception e) {System.out.print(e.getStackTrace());}
		return "success";
		
	}
	@PutMapping("/accepter/{id}")
	public Invitation accepter(@PathVariable long id,final HttpServletRequest request) {
		Invitation invitation= invRepository.findById(id).get();
		invitation.setAccepted(true);
		return invService.accepter(invitation);
		
	
		
	}
	@GetMapping("notificationemp/{id}")
	public List<Invitation>Invitationsemp(@PathVariable long id,final HttpServletRequest request){
		List<Invitation>invitations=invService.ListerInvitationem(id);
		
		
		return invitations;
	}
	@GetMapping("listerinv/{id}")
	public List<Invitation>Invitationentr(@PathVariable long id,final HttpServletRequest request){
		List<Invitation>invitations=invService.ListerInvitationent(id);
		return invitations;
	}
}
