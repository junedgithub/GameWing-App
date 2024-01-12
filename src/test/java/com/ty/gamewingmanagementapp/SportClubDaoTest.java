package com.ty.gamewingmanagementapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ty.gamewingmanagementapp.controller.SportClubController;
import com.ty.gamewingmanagementapp.dto.ResponseStructure;
import com.ty.gamewingmanagementapp.dto.SportClub;

@SpringBootTest
class SportClubDaoTest
{
	@Autowired
	private SportClubController clubController;

	@Test
	public void findSportClubByID()
	{
		int id =1;
		
		ResponseEntity<ResponseStructure<SportClub>> expectedOutput = clubController.findSportClubById(id);
		
		if(expectedOutput.getStatusCodeValue() == HttpStatus.FOUND.value())
		{
			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.FOUND.value());
		}else
		{
			assertEquals(expectedOutput.getStatusCodeValue(), HttpStatus.NOT_FOUND.value());
		}
	}
	 

}
