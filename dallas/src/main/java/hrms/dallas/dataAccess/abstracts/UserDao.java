package hrms.dallas.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.dallas.entities.concretes.User;

public interface UserDao extends JpaRepository<User,Integer>{

}
