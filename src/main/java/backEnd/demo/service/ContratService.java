package backEnd.demo.service;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;


import backEnd.demo.entity.contrat;

public interface ContratService {
	 contrat saveContrat(MultipartFile file,String type,LocalDate date_debut,LocalDate date_fin) throws Exception;

	 contrat getContrat(String fileId) throws Exception;
}
