package com.userdbService.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userdbService.entity.Addressbean;
import com.userdbService.entity.UserAdressDetails;
import com.userdbService.entity.UserDetails;
import com.userdbService.repository.UsertransactionDao;

@RestController
@RequestMapping("/rest/db")
public class UserController {

	@Autowired
	UsertransactionDao dao;

	@GetMapping("/all")
	public List<UserDetails> findalluserRecords() {
		return dao.findAll();
	}

	@GetMapping("/{name}")
	public List<Integer> findalluserByname(@PathVariable("name") final String name) {
		return dao.findByname(name).stream().map(UserDetails::getId).collect(Collectors.toList());
	}

	@GetMapping("/rec/{name}")
	public List<UserDetails> findFulluserByname(@PathVariable("name") final String name) {
		return dao.findByname(name);
	}

	@PostMapping("/addUser")
	public UserDetails addUser(@RequestBody UserDetails user) {
		return dao.save(user);
	}

}
