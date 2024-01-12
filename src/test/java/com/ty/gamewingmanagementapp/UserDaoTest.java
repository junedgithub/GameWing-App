package com.ty.gamewingmanagementapp;

import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ty.gamewingmanagementapp.controller.UserController;
import com.ty.gamewingmanagementapp.dao.UserDao;
import com.ty.gamewingmanagementapp.dto.ResponseStructure;
import com.ty.gamewingmanagementapp.dto.Role;
import com.ty.gamewingmanagementapp.dto.SportClub;
import com.ty.gamewingmanagementapp.dto.User;
import com.ty.gamewingmanagementapp.exception.IdNotFoundException;
import com.ty.gamewingmanagementapp.repository.UserRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.val;

@SpringBootTest
class UserDaoTest {
	@Autowired
	private UserController userController;

	@Test
	@Disabled
	public void registerAdminTest() {
		User inputUser = new User();
		inputUser.setName("Radhika");
		inputUser.setEmail("radhika@gmail");
		inputUser.setPassword("Radhika@123");
		inputUser.setRole(Role.Admin);
		ResponseEntity<ResponseStructure<User>> expectedOutput = userController.registerAdmin(inputUser);
		if(expectedOutput.getStatusCodeValue()==HttpStatus.CREATED.value())
		assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.CREATED.value());
        else {
		 assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.BAD_REQUEST.value());
		}
	}


	@Test
	@Disabled
	public void addOwnerTest() {
		User inputUser = new User();
		inputUser.setName("Juned");
		inputUser.setEmail("juned@gmail");
		inputUser.setPassword("Juned@123");
		inputUser.setRole(Role.Owner);
		ResponseEntity<ResponseStructure<User>> expectedOutput = userController.addOwner(inputUser);
		if(expectedOutput.getStatusCodeValue()==HttpStatus.CREATED.value())
		assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.CREATED.value());
        else {
		 assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.BAD_REQUEST.value());
		}
	}

	@Test
	@Disabled
	public void loginTest() {
		User inputUser = new User();
		inputUser.setEmail("radhika@gmail");
		inputUser.setPassword("Radhika@123");
		ResponseEntity<ResponseStructure<User>> expectedOutput = userController.login(inputUser);
		if (expectedOutput.getStatusCodeValue() == HttpStatus.CREATED.value()) {

			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.CREATED.value());
		}else {
			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.BAD_REQUEST.value());
		}
	}
	
	@Test
	@Disabled
	public void deleteOwnerTest() {
		int id = 4;
		
		ResponseEntity<ResponseStructure<User>> expectedOutput = userController.deleteOwner(id);
		if (expectedOutput.getStatusCodeValue() == HttpStatus.CREATED.value()) {

			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.CREATED.value());
		}else {
			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.BAD_REQUEST.value());
		}
	}
	

	@Test
	@Disabled
	public void updateOwnerTest() {
		int id = 5;
		
		User inputUser = new User();
		inputUser.setName("Javi");
		inputUser.setEmail("javeed@gmail");
		inputUser.setPassword("Javeed@123");
		inputUser.setRole(Role.Owner);
		
		ResponseEntity<ResponseStructure<User>> expectedOutput = userController.updateOwner(id,inputUser);
		if (expectedOutput.getStatusCodeValue() == HttpStatus.OK.value()) {

			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.OK.value());
		}else {
			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.BAD_REQUEST.value());
		}
	}
	

	@Test
	@Disabled
	public void addManagerTest() {
		
		User inputUser = new User();
		inputUser.setName("Trupti");
		inputUser.setEmail("Trupti@gmail");
		inputUser.setPassword("Trupti@123");
		inputUser.setRole(Role.Manager);
		
		ResponseEntity<ResponseStructure<User>> expectedOutput = userController.addManager(inputUser);
		if (expectedOutput.getStatusCodeValue() == HttpStatus.CREATED.value()) {

			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.CREATED.value());
		}else {
			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.BAD_REQUEST.value());
		}
	}
	
	@Test
	@Disabled
	public void deleteManagerTest()
	{
		int id=7;
		
		ResponseEntity<ResponseStructure<User>> expectOutput = userController.deleteManager(id);
		if(expectOutput.getStatusCodeValue() == HttpStatus.OK.value())
		{
			assertEquals(expectOutput.getStatusCodeValue(), HttpStatus.OK.value());
		}else
		{
			assertEquals(expectOutput.getStatusCodeValue(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@Test
	@Disabled
	public void updateManagerTest() {
		int id = 11;
		
		User inputUser = new User();
		inputUser.setName("yash");
		inputUser.setEmail("yash@gmail");
		inputUser.setPassword("yash@123");
		inputUser.setRole(Role.Manager);
		
		ResponseEntity<ResponseStructure<User>> expectedOutput = userController.updateManager(id,inputUser);
		if (expectedOutput.getStatusCodeValue() == HttpStatus.OK.value()) {

			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.OK.value());
		}else {
			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.BAD_REQUEST.value());
		}
	}
	
	@Test
	@Disabled
	public void addCustomerTest()
	{
		User inputUser = new User();
		inputUser.setName("Anjali");
		inputUser.setEmail("anjali@gmail");
		inputUser.setPassword("anjali@123");
		inputUser.setRole(Role.Customer);
		
		ResponseEntity<ResponseStructure<User>> expectedOutput = userController.addCustomer(inputUser);
		if(expectedOutput.getStatusCodeValue() == HttpStatus.OK.value())
		{
			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.OK.value());
		}else
		{
			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.BAD_REQUEST.value());
		}
	}
	
	@Test
	@Disabled
	public void deleteCustomerTest()
	{
		int id =12 ;
		
		ResponseEntity<ResponseStructure<User>> expectedOutput = userController.deleteOwner(id);
		if (expectedOutput.getStatusCodeValue() == HttpStatus.CREATED.value()) {

			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.CREATED.value());
		}else {
			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.BAD_REQUEST.value());
		}
	}
		
	
	@Test
	@Disabled
	public void updateCustomerTest() {
		int id = 13;
		
		User inputUser = new User();
		inputUser.setName("Seema");
		inputUser.setEmail("Seema@gmail");
		inputUser.setPassword("Seema@123");
		inputUser.setRole(Role.Customer);
		
		ResponseEntity<ResponseStructure<User>> expectedOutput = userController.updateManager(id,inputUser);
		if (expectedOutput.getStatusCodeValue() == HttpStatus.OK.value()) {

			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.OK.value());
		}else {
			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.BAD_REQUEST.value());
		}
	}
	
	
	@Test
	public void addSportClubTest()
	{
		SportClub sportClub = new SportClub();
		sportClub.setLocation("Deccan");
		
		ResponseEntity<ResponseStructure<SportClub>> expectedOutput = userController.addSportClub(sportClub);
		
		if(expectedOutput.getStatusCodeValue() == HttpStatus.OK.value())
		{
			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.OK.value());
		}else
		{
			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.BAD_REQUEST.value());
		}
	}
}
