package com.ty.gamewingmanagementapp.service;

import com.ty.gamewingmanagementapp.dao.PlayAreaDao;
import com.ty.gamewingmanagementapp.dto.PlayArea;
import com.ty.gamewingmanagementapp.dto.ResponseStructure;
import com.ty.gamewingmanagementapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlayAreaService {
    @Autowired
    private PlayAreaDao playAreaDao;
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
}
