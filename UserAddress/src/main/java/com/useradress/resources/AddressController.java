package com.useradress.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.useradress.model.Addressbean;
import com.useradress.model.UserAdressDetails;
import com.useradress.repository.UserAddressdao;

@RestController
@RequestMapping("/CliAdress")
public class AddressController {
	
	@Autowired
	RestTemplate template;
	
	@Autowired
	UserAddressdao  adddao;
	
		@GetMapping("/{name}")
		public List<UserAdressDetails> getAddressByname(@PathVariable("name")final String name){
			List<Integer> userdetails =template.getForObject("http://localhost:8300/rest/db/"+name,List.class);
			  Integer a=userdetails.get(0);
			 return adddao.findByUserId(a);
		}

	
	@PostMapping("/addaddress")
	public UserAdressDetails addaddress(@RequestBody Addressbean addressbean) {
		List<Integer> userdetails =template.getForObject("http://localhost:8300/rest/db/"+addressbean.getName(),List.class);
		  Integer a=userdetails.get(0);

		UserAdressDetails add=new UserAdressDetails();
		add.setAddressline(addressbean.getAddressline());
		add.setCity(addressbean.getCity());
		add.setState(addressbean.getState());
		add.setPincode(addressbean.getPincode());
		add.setUserId(a);
		
		return adddao.save(add);
	}
	
	
}
