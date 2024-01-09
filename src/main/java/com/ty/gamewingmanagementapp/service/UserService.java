package com.ty.gamewingmanagementapp.service;

import com.ty.gamewingmanagementapp.dao.SportClubDao;
import com.ty.gamewingmanagementapp.dao.UserDao;
import com.ty.gamewingmanagementapp.dto.ResponseStructure;
import com.ty.gamewingmanagementapp.dto.SportClub;
import com.ty.gamewingmanagementapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private SportClubDao sportClubDao;

    public ResponseEntity<ResponseStructure<User>> register(User user) {
        User receivedUser = userDao.register(user);
        if (receivedUser!=null) {
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessage("Admin Created");
            responseStructure.setData(user);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
        }else{
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage("Not Created");
            responseStructure.setData(user);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseStructure<User>> addOwner(User owner) {
        User receivedUser = userDao.addOwner(owner);
        if (receivedUser!=null) {
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessage("Owner Created");
            responseStructure.setData(owner);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
        }else{
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage("Not Created");
            responseStructure.setData(owner);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseStructure<User>> login(User user) {
        User receivedUser = userDao.login(user);
        if (receivedUser!=null) {
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessage("Owner Created");
            responseStructure.setData(user);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
        }else{
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage("Not Created");
            responseStructure.setData(user);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseStructure<User>> deleteOwner(int id) {
        User receivedUser = userDao.deleteOwner(id);
        if (receivedUser!=null) {
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessage("Owner Deleted");
            responseStructure.setData(receivedUser);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
        }else{
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage("Not Created");
            responseStructure.setData(receivedUser);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseStructure<User>> addManager(User manager) {
        User receivedUser = userDao.addManager(manager);
        if (receivedUser!=null) {
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessage("Add Manager");
            responseStructure.setData(manager);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
        }else{
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage("Not Created");
            responseStructure.setData(manager);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseStructure<User>> deleteManager(int id) {
        User receivedUser = userDao.deleteManager(id);
        if (receivedUser!=null) {
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessage("Delete Manager");
            responseStructure.setData(receivedUser);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
        }else{
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage("Not Created");
            responseStructure.setData(receivedUser);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseStructure<User>> updateManager(int id, User updateManager) {
        User receivedUser = userDao.updateManager(id,updateManager);
        if (receivedUser!=null) {
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("Update Manager");
            responseStructure.setData(receivedUser);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
        }else{
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage("Not Created");
            responseStructure.setData(receivedUser);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseStructure<User>> updateOwner(int id, User updateOwner) {
        User receivedUser = userDao.updateOwner(id,updateOwner);
        if (receivedUser!=null) {
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("Update Owner");
            responseStructure.setData(receivedUser);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
        }else{
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage("Not Created");
            responseStructure.setData(receivedUser);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseStructure<User>> addCustomer(User customer) {
        User receivedUser = userDao.addCustomer(customer);
        if (receivedUser!=null) {
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("Added Customer");
            responseStructure.setData(receivedUser);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
        }else{
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage("Not Created");
            responseStructure.setData(receivedUser);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseStructure<User>> deleteCustomer(int id) {
        User receivedUser = userDao.deleteCustomer(id);
        if (receivedUser!=null) {
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("Added Customer");
            responseStructure.setData(receivedUser);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
        }else{
            ResponseStructure<User> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage("Not Created");
            responseStructure.setData(receivedUser);
            return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseStructure<SportClub>> addSportClub(SportClub sportClub) {
        SportClub receivedSportClub = sportClubDao.addSportClub(sportClub);
        if (receivedSportClub!=null) {
            ResponseStructure<SportClub> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("Added Customer");
            responseStructure.setData(receivedSportClub);
            return new ResponseEntity<ResponseStructure<SportClub>>(responseStructure,HttpStatus.OK);
        }else{
            ResponseStructure<SportClub> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage("Not Created");
            responseStructure.setData(receivedSportClub);
            return new ResponseEntity<ResponseStructure<SportClub>>(responseStructure,HttpStatus.BAD_REQUEST);
        }
    }
}
