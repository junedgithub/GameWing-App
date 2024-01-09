package com.ty.gamewingmanagementapp.service;

import com.ty.gamewingmanagementapp.dao.PlayAreaDao;
import com.ty.gamewingmanagementapp.dto.PlayArea;
import com.ty.gamewingmanagementapp.dto.ResponseStructure;
import com.ty.gamewingmanagementapp.dto.SportClub;
import com.ty.gamewingmanagementapp.dto.User;
import com.ty.gamewingmanagementapp.exception.SportClubNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlayAreaService {
    @Autowired
    private PlayAreaDao playAreaDao;
    
    @Autowired
    private SportClubService clubService;
    public ResponseEntity<ResponseStructure<PlayArea>> addPlayArea(PlayArea playArea) {
        PlayArea recPlayArea = playAreaDao.addPlayArea(playArea);
        if (recPlayArea!=null) {
            ResponseStructure<PlayArea> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessage("Play Area Created");
            responseStructure.setData(playArea);
            return new ResponseEntity<ResponseStructure<PlayArea>>(responseStructure,HttpStatus.CREATED);
        }else{
            ResponseStructure<PlayArea> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage("Not Created");
            responseStructure.setData(playArea);
            return new ResponseEntity<ResponseStructure<PlayArea>>(responseStructure,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseStructure<PlayArea>> addPlayAreaToSportClub(int areaId, int clubId) {
        PlayArea recPlayArea = playAreaDao.addPlayAreaToSportClub(areaId,clubId);
        if (recPlayArea!=null) {
            ResponseStructure<PlayArea> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessage("Play Area added to SportClub");
            responseStructure.setData(recPlayArea);
            return new ResponseEntity<ResponseStructure<PlayArea>>(responseStructure,HttpStatus.CREATED);
        }else{
            ResponseStructure<PlayArea> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage("Not Created");
            responseStructure.setData(recPlayArea);
            return new ResponseEntity<ResponseStructure<PlayArea>>(responseStructure,HttpStatus.BAD_REQUEST);
        }
    }

	public ResponseEntity<ResponseStructure<List<PlayArea>>> displayAllplayArea(int sportclubId) 
	{
		SportClub sb=clubService.findSportClub(sportclubId);
		if(sb != null)
		{
		List<PlayArea> playAreas= sb.getPlayAreas();
		ResponseStructure<List<PlayArea>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(playAreas);
		
		return new ResponseEntity<ResponseStructure<List<PlayArea>>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new SportClubNotFoundException();
		}
	}
    
    
}
