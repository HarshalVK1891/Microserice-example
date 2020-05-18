package com.userdbService.resource;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.userdbService.entity.UserDetails;
import com.userdbService.repository.UsertransactionDao;

@RestController
@RequestMapping(value = "/kafka/")
public class KafkaController {

	
	@Autowired
	KafkaSender kafkaSender;
	
	@Autowired
	UsertransactionDao dao;
	
	private final ObjectMapper objectMapper = new ObjectMapper();

	@GetMapping(value = "/sendingMsgfromOtherService")
	public String sendingMsgfromOtherService(@RequestParam("message") String message) {
		kafkaSender.send(message);
		return "Message sent";
	}
	
	@GetMapping("/all-user")
	public String  findalluserRecords() {
		List<UserDetails> list=dao.findAll();
		kafkaSender.send(list.toString());
		return "Message sent";
	}
	
	@GetMapping("/user-record/{name}")
	public  String findFullRecordOfUserByname(@PathVariable("name") final String name) throws JsonProcessingException {
		List<UserDetails> list=dao.findByname(name);
		StringBuilder br=new StringBuilder();
		for (Iterator<UserDetails> iterator = list.iterator(); iterator.hasNext();) {
			UserDetails userDetails =  iterator.next();
			br.append(objectMapper.writeValueAsString(userDetails));
			kafkaSender.send(br.toString());
		}
		return "Message sent";
	}
	
}
