package backEnd.demo.service;

import java.time.LocalDate;
import java.util.List;

import backEnd.demo.entity.Invitation;
import org.springframework.web.multipart.MultipartFile;


public interface InvService {

	public List<Invitation> ListerInvitationent(long iden);
	public List<Invitation> ListerInvitationem(long idem);
	public Invitation inviter(long ide, long idem, MultipartFile file, String type, LocalDate date_debut, LocalDate date_fin)throws Exception ;
	public Invitation accepter(Invitation invitation);
}
