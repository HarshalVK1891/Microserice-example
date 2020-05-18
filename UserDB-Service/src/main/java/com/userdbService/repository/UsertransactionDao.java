package com.userdbService.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.userdbService.entity.UserDetails;

@Repository
@Transactional
public interface UsertransactionDao extends GenericDao<UserDetails, Integer>{

	List<UserDetails> findByname(String name);
}
