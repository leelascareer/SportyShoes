package com.ss.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import com.ss.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.emailid = ?1 and u.pwd=?2")
    public User findByEmail(String email, String password);

	@Query("SELECT u FROM User u WHERE CONCAT(u.f_name, ' ', u.l_name) LIKE %?1%")
	public List<User> search(String keyword);
}
