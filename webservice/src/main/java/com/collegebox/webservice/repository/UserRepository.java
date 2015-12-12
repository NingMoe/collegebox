package com.collegebox.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.collegebox.webservice.pojo.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Transactional(readOnly = true)
    User findByUsername(String username);
	
	@Transactional(readOnly = true)
    User findByEmail(String email);

	@Transactional(readOnly = true)
    User findByEmailAndActivationKey(String email, String activationKey);

	@Transactional(readOnly = true)
    User findByEmailAndResetPasswordKey(String email, String resetPasswordKey);
	
	@Modifying
	@Query("update User u set u.password = ?2 where u.id = ?1")
	int editPassword(Long id, String password);
	
	@Transactional(readOnly = true)
	@Query("select u.password from User u where u.id = ?1")
	String findPasswordById(Long id);
	
	@Transactional(readOnly = true)
	int countByUsername(String username);
	
	@Transactional(readOnly = true)
	int countByEmail(String email);
	
	@Modifying
	@Query("update User u set u.firstName = ?1.firstName, u.lastName = ?1.lastName, u.portrait = ?1.portrait,"
			+ "u.nickName = ?1.nickName, u.mobile = ?1.mobile where u.id = ?1.id")
	int editBasicInfo(User user);

}