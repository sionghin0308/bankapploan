package com.application.bank.respository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.application.bank.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	User findByUsernameAndPassword(String username, String password);
	List<User> findByUserRole(int userRole);
}
