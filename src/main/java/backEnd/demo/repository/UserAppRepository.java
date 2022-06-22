package backEnd.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import backEnd.demo.entity.UserApp;
public interface UserAppRepository extends JpaRepository<UserApp,Long> {
    UserApp findByUsername(String username);


}
