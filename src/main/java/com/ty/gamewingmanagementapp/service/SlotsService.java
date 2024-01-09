package com.ty.gamewingmanagementapp.service;

import com.ty.gamewingmanagementapp.dao.SlotsDao;
import com.ty.gamewingmanagementapp.dto.ResponseStructure;
import com.ty.gamewingmanagementapp.dto.Slots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SlotsService {
    @Autowired
    private SlotsDao slotsDao;
    public ResponseEntity<ResponseStructure<Slots>> saveSlot(Slots slot) {
        Slots recSlot = slotsDao.saveSlots(slot);
        if (recSlot!=null) {
            ResponseStructure<Slots> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessage("Slot Created");
            responseStructure.setData(slot);
            return new ResponseEntity<ResponseStructure<Slots>>(responseStructure,HttpStatus.CREATED);
        }else{
            ResponseStructure<Slots> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage("Not Created");
            responseStructure.setData(slot);
            return new ResponseEntity<ResponseStructure<Slots>>(responseStructure,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseStructure<Slots>> deleteSlot(int slot) {
        Slots recSlot = slotsDao.deleteSlots(slot);
        if (recSlot!=null) {
            ResponseStructure<Slots> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessage("Slot Deleted");
            responseStructure.setData(recSlot);
            return new ResponseEntity<ResponseStructure<Slots>>(responseStructure,HttpStatus.CREATED);
        }else{
            ResponseStructure<Slots> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage("Not Created");
            responseStructure.setData(recSlot);
            return new ResponseEntity<ResponseStructure<Slots>>(responseStructure,HttpStatus.BAD_REQUEST);
        }
    }
}
