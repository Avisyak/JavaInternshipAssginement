package com.InternSathi.InternSathiAssginement.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InternSathi.InternSathiAssginement.Model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsernameAndPassword(String un, String psw);

	

}
