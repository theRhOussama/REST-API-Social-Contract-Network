package backEnd.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import backEnd.demo.entity.contrat;

public interface Contratrepository extends JpaRepository<contrat, String> {

}
