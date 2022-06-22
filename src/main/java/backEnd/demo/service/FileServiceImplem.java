package backEnd.demo.service;

import backEnd.demo.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import backEnd.demo.entity.File;

import org.springframework.util.StringUtils;
@Service
public class FileServiceImplem implements FileService {
	@Autowired
	private FileRepository fileRepository;

	@Override
	public File saveAttachment(MultipartFile file) throws Exception {
		  String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	       try {
	            if(fileName.contains("..")) {
	                throw  new Exception("Filename contains invalid path sequence "
	                + fileName);
	            }

	            File attachment
	                    = new File(fileName,
	                    file.getContentType(),
	                    file.getBytes());
	            return fileRepository.save(attachment);

	       } catch (Exception e) {
	            throw new Exception("Could not save File: " + fileName);
	       }
	}

	@Override
	public File getAttachment(String fileId) throws Exception {
		// TODO Auto-generated method stub
		 return 
				 fileRepository.findById(fileId)
	                .orElseThrow(
	                        () -> new Exception("File not found with Id: " + fileId));
	    }
	}

