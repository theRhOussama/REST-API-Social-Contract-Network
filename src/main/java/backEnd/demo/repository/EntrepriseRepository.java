package backEnd.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import backEnd.demo.entity.EntrepriseApp;

public interface EntrepriseRepository  extends JpaRepository<EntrepriseApp,Long> {
    public EntrepriseApp findByUserUsername(String username);

}
