/*
 * add your task as well as functionality here
 */

package com.example.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Policy;
import com.example.entity.Policy.PolicyStatus;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long>{
	
	Optional<Policy> findByPolicyIdAndStatus(Long policyId, PolicyStatus status);

}
