/*
 * add your task as well as functionality here
 * task : 175 -> Design web service to add the settlement details once claim is done 
 * developed by Siddhi
 * 
 */

package com.example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Serializable> {
}
