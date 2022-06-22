package backEnd.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import backEnd.demo.entity.RoleApp;

public interface RoleAppRepository extends JpaRepository<RoleApp,Long> {
    RoleApp findByRoleName(String roleName);


}
