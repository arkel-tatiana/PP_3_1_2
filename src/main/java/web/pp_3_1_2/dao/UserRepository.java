package web.pp_3_1_2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import web.pp_3_1_2.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
}
