package backEnd.demo.repository;

import backEnd.demo.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FileRepository extends JpaRepository<File, String> {

}
