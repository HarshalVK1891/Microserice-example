package com.useradress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.useradress.model.UserAdressDetails;


@Repository
public interface UserAddressdao extends GenericDao<UserAdressDetails, Integer> {

	@Query( "FROM UserAdressDetails   WHERE userId = ?1")
	List<UserAdressDetails> findByUserId(Integer id);

}
