package com.example.customerLogin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@Autowired 
private DataRepo userRepository;
	
	@RequestMapping("/home")
	public String firstHandle() {  
		   System.out.println("login");
		User n = new User();
	    n.setName("kad");
	   n.setId(4);
	   userRepository.save(n);
	   System.out.println("login2");
	    //return "Saved";
       Optional<User> u = 		userRepository.findById(4);
		
       User user = u.get(); 
       
       System.out.println(user.getName());
       user.setName("buzz");
       System.out.println(user.getName());
       User a = userRepository.save(user);
       System.out.println(a);
       
      List<User> listofuser=  userRepository.findAll();
       
      listofuser.forEach(e->{
    	  System.out.println(e.toString());
      });
       
      List<User> specific = userRepository.findByNa("dagad");
      specific.forEach(e->{
    	  System.out.println(e.toString());
      }); 
		return "home"; 
	}
	
	@RequestMapping("/contact")
	public String firstHandle1() {
		return "contact"; 
	}
}
