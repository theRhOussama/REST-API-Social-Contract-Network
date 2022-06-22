package backEnd.demo.service;

import java.time.LocalDate;

import backEnd.demo.repository.Contratrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import backEnd.demo.entity.contrat;
@Service
public class ContratServiceImplem implements ContratService {
	@Autowired
	private Contratrepository contratrepository;

	@Override
	public contrat saveContrat(MultipartFile file, String type, LocalDate date_debut, LocalDate date_fin)
			throws Exception {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	       try {
	            if(fileName.contains("..")) {
	                throw  new Exception("Filename contains invalid path sequence "
	                + fileName);
	            }

	            contrat attachment
	                    = new contrat(fileName,
	                    file.getContentType(),
	                    file.getBytes());
	            attachment.setDate_debut(date_debut);
	            attachment.setDate_fin(date_fin);
	            attachment.setType(type);
	            return contratrepository.save(attachment);

	       } catch (Exception e) {
	            throw new Exception("Could not save File: " + fileName);
	       }
		
	}

	@Override
	public contrat getContrat(String fileId) throws Exception {
		// TODO Auto-generated method stub
		 return 
				contratrepository.findById(fileId)
	                .orElseThrow(
	                        () -> new Exception("File not found with Id: " + fileId));
	}

}
