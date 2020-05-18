package com.userdetails.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.userdetails.model.MobileBean;
import com.userdetails.model.Phonetype;
import com.userdetails.model.UserMobileDetails;
import com.userdetails.repository.MobileDao;

@RestController
@RequestMapping("/Climob")
public class MobileController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	MobileDao mobdao;

	//@CrossOrigin(origins = "http://localhost:8302")
		@GetMapping("/{name}")
		public List<String> getmobileByname(@PathVariable("name") final String name) {
			List<Integer> userdetails = restTemplate.getForObject("http://localhost:8300/rest/db/" + name, List.class);
			Integer a = userdetails.get(0);
			return mobdao.findByUserId(a).stream().map(UserMobileDetails :: getMobile).collect(Collectors.toList());
		}
	
	//@CrossOrigin(origins = "http://localhost:8302")
	@PostMapping("/addmmobile")
	public UserMobileDetails addmobileforname(@RequestBody MobileBean bean) {
		List<Integer> userdetails = restTemplate.getForObject("http://localhost:8300/rest/db/" + bean.getName(),List.class);
		Integer a = userdetails.get(0);
	 	
		UserMobileDetails mob = new UserMobileDetails();
		mob.setMobile(bean.getMobile());
		mob.setUserId(a);
		mob.setType(bean.getType().equalsIgnoreCase("official")?Phonetype.official:Phonetype.personal);
		return mobdao.save(mob);
	}

	

}
