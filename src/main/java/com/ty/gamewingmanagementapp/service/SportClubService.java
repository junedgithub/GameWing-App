package com.ty.gamewingmanagementapp.service;

import com.ty.gamewingmanagementapp.dao.SportClubDao;
import com.ty.gamewingmanagementapp.dto.PlayArea;
import com.ty.gamewingmanagementapp.dto.ResponseStructure;
import com.ty.gamewingmanagementapp.dto.SportClub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SportClubService {
    @Autowired
    private SportClubDao sportClubDao;

    public ResponseEntity<ResponseStructure<SportClub>> addSportClub(SportClub sportClub) {
         SportClub recSportClub= sportClubDao.addSportClub(sportClub);
        if (recSportClub!=null) {
            ResponseStructure<SportClub> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessage("Sport Club Created");
            responseStructure.setData(recSportClub);
            return new ResponseEntity<ResponseStructure<SportClub>>(responseStructure,HttpStatus.CREATED);
        }else{
            ResponseStructure<SportClub> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage("Not Created");
            responseStructure.setData(recSportClub);
            return new ResponseEntity<ResponseStructure<SportClub>>(responseStructure,HttpStatus.BAD_REQUEST);
        }
    }

	public ResponseEntity<ResponseStructure<SportClub>> findSportClub(int sportclubId) {
		SportClub sp=sportClubDao.findSportClubById(sportclubId);
		
		if(sp != null)
		{
		ResponseStructure<SportClub> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(sp);
		
		return new ResponseEntity<ResponseStructure<SportClub>>(responseStructure, HttpStatus.FOUND);
		}else
		{
			ResponseStructure<SportClub> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(null);
			
			return new ResponseEntity<ResponseStructure<SportClub>>(responseStructure, HttpStatus.NOT_FOUND);
		}
		
		
		
	}
}
