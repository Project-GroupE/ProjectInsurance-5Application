/*
 * add your task as well as functionality here
 */

package com.example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable>{

	/*
	 * findByUserId() -> added by sairaj
	 * this method fetch details from DB using user Id
	 */
	public User findByUserId(Integer userId);
}
