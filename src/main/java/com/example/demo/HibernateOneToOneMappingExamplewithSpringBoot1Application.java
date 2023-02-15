package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Gendre;
import com.example.demo.model.User;
import com.example.demo.model.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class HibernateOneToOneMappingExamplewithSpringBoot1Application  implements  CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(HibernateOneToOneMappingExamplewithSpringBoot1Application.class, args);
	}
	@Autowired 
	private UserRepository userRepository ;
	
	
    @Autowired 
	private UserProfileRepository userProfileRepository  ;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User user =  new User();
		user.setName("Ahmed");
		user.setEmail("kouraichiahmed2@gmail.com");
		
		
		UserProfile  userProfile = new UserProfile();
		userProfile.setAdress(null);
		userProfile.setBirthOfDate(LocalDate.of(1992, 03,16));
		userProfile.setGender(Gendre.MALE);
		userProfile.setPhoneNumber("55559850");
		
		user.setUserProfile(userProfile);
		userProfile.setUser(user);
		
		userRepository.save(user);
		userProfileRepository.save(userProfile);
		
		
		
	}

}
