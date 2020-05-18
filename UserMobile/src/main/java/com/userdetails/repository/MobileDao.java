package com.userdetails.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.userdetails.model.UserMobileDetails;

@Repository
@Transactional
public interface MobileDao extends GenericDao<UserMobileDetails, Integer>{

	@Query( "FROM UserMobileDetails   WHERE userId = ?1")
	List<UserMobileDetails> findByUserId(Integer id);
}
