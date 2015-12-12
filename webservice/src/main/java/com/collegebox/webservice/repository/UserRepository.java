package com.collegebox.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegebox.webservice.pojo.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByEmail(String email);

    User findByEmailAndActivationKey(String email, String activationKey);

    User findByEmailAndResetPasswordKey(String email, String resetPasswordKey);

}