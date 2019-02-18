package com.example.DAO;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
 
//import com.example.jsonFile.User;
import com.example.jsonFile.User;
import com.example.*;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> { //Long is the primary key. Long is a type - why Long?

	Page<User> findAll(Pageable pageable);
}
//
//@Component
//public class UserRepositoryCommandLineRunner2 implements CommandLineRunner {
//
//	private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserRepositoryCommandLineRunner2.class);
//
//	@Autowired
//	private UserRepository userRepository; // userDaoService;
//
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//
//		User user = new User("Joe", "Admin");
//		User user2 = new User("Frank", "Peon");
//
//		userRepository.save(user);
//		userRepository.save(user2);
//		
//		 Optional<User> userWithIdOne = userRepository.findById(1L); 
//		 
//		 
//		
//		
//
//		// New User is created: User [id=1, name=Jack, role=Admin]
//		log.info("New User is created: " + user);
//		log.info("New User is created: " + user2);
//		
//		log.info("User is retrieved: " + userWithIdOne );
//		
//
//		List<User> usersList = userRepository.findAll();
//		
//		log.info("Users are: " + usersList );
