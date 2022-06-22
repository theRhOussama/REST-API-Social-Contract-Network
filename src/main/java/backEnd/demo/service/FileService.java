package backEnd.demo.service;

import org.springframework.web.multipart.MultipartFile;

import backEnd.demo.entity.File;



public interface FileService {
  File saveAttachment(MultipartFile file) throws Exception;

	 File getAttachment(String fileId) throws Exception;

}
