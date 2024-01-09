package com.ty.gamewingmanagementapp.controller;

import com.ty.gamewingmanagementapp.dto.Booking;
import com.ty.gamewingmanagementapp.dto.PlayArea;
import com.ty.gamewingmanagementapp.dto.ResponseStructure;
import com.ty.gamewingmanagementapp.dto.SportClub;
import com.ty.gamewingmanagementapp.dto.User;
import com.ty.gamewingmanagementapp.service.SportClubService;
import com.ty.gamewingmanagementapp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SportClubService sportClubService;
    @Operation(description = "Register Admin",summary = "Admin Details get added in database")
    @ApiResponses(value = {@ApiResponse(description = "Register admin",responseCode = "302"),@ApiResponse(description = "Not Created",responseCode = "404")})
    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<User>> registerAdmin(@RequestBody User user){
        return userService.register(user);
    }

    @Operation(description = "Login User",summary = "User Credentail is verified database")
    @ApiResponses(value = {@ApiResponse(description = "User Login",responseCode = "302"),@ApiResponse(description = "Not Found",responseCode = "404")})
    @PostMapping("/login")
    public ResponseEntity<ResponseStructure<User>> login(@RequestBody User user){
        return userService.login(user);
    }

    @Operation(description = "Add Owner",summary = "Owner Details get added in database")
    @ApiResponses(value = {@ApiResponse(description = "Register admin",responseCode = "302"),@ApiResponse(description = "Not Created",responseCode = "404")})
    @PostMapping("/addowner")
    public ResponseEntity<ResponseStructure<User>> addOwner(@RequestBody User owner){
        return userService.addOwner(owner);
    }

    @Operation(description = "Delete Owner",summary = "Owner Details get deleted in database")
    @ApiResponses(value = {@ApiResponse(description = "Delete admin",responseCode = "302"),@ApiResponse(description = "Not Created",responseCode = "404")})
    @DeleteMapping("/deleteowner/ownerid/{id}")
    public ResponseEntity<ResponseStructure<User>> deleteOwner(@PathVariable int id){
        return userService.deleteOwner(id);
    }
    @Operation(description = "Update Owner",summary = "Owner Details get up in database")
    @ApiResponses(value = {@ApiResponse(description = "Update ",responseCode = "302"),@ApiResponse(description = "Not Created",responseCode = "404")})
    @PutMapping("/deleteOwner/ownerid/{id}")
    public ResponseEntity<ResponseStructure<User>> updateOwner(@PathVariable int id,@RequestBody User updateOwner){
        return userService.updateOwner(id,updateOwner);
    }

    @Operation(description = "Add Manager",summary = "Manager Details get added in database")
    @ApiResponses(value = {@ApiResponse(description = "Register manager",responseCode = "302"),@ApiResponse(description = "Not Created",responseCode = "404")})
    @PostMapping("/addmanager")
    public ResponseEntity<ResponseStructure<User>> addManager(@RequestBody User manager){
        return userService.addManager(manager);
    }

    @Operation(description = "Delete Manager",summary = "Manager Details get deleted in database")
    @ApiResponses(value = {@ApiResponse(description = "Delete admin",responseCode = "302"),@ApiResponse(description = "Not Created",responseCode = "404")})
    @DeleteMapping("/deleteManager/managerid/{id}")
    public ResponseEntity<ResponseStructure<User>> deleteManager(@PathVariable int id){
        return userService.deleteManager(id);
    }

    @Operation(description = "Update Manager",summary = "Manager Details get up in database")
    @ApiResponses(value = {@ApiResponse(description = "Update manager",responseCode = "302"),@ApiResponse(description = "Not Created",responseCode = "404")})
    @PutMapping("/updateManager/managerid/{id}")
    public ResponseEntity<ResponseStructure<User>> updateManager(@PathVariable int id,@RequestBody User updateManager){
        return userService.updateManager(id,updateManager);
    }

    @Operation(description = "Add Customer",summary = "Customer Details get added in database")
    @ApiResponses(value = {@ApiResponse(description = "Add Customer",responseCode = "302"),@ApiResponse(description = "Not Created",responseCode = "404")})
    @PostMapping("/addcustomer")
    public ResponseEntity<ResponseStructure<User>> addCustomer(@RequestBody User customer){
        return userService.addCustomer(customer);
    }

    @Operation(description = "Delete Customer",summary = "Customer Details get deleted in database")
    @ApiResponses(value = {@ApiResponse(description = "Delete admin",responseCode = "302"),@ApiResponse(description = "Not Created",responseCode = "404")})
    @DeleteMapping("/deletecustomer/customerid/{id}")
    public ResponseEntity<ResponseStructure<User>> deleteCustomer(@PathVariable int id){
        return userService.deleteCustomer(id);
    }

    @Operation(description = "Update Customer",summary = "Customer Details get up in database")
    @ApiResponses(value = {@ApiResponse(description = "Update Customer",responseCode = "302"),@ApiResponse(description = "Not Created",responseCode = "404")})
    @PutMapping("/updateCustomer/customerid/{id}")
    public ResponseEntity<ResponseStructure<User>> updateCustomer(@PathVariable int id,@RequestBody User updateCustomer){
        return userService.updateManager(id,updateCustomer);
    }

    @Operation(description = "Add SportClub",summary = "SportClub get added in database")
    @ApiResponses(value = {@ApiResponse(description = "Add SportClub",responseCode = "302"),@ApiResponse(description = "Not Created",responseCode = "404")})
    @PostMapping("/addsportclub")
    public ResponseEntity<ResponseStructure<SportClub>> addSportClub(@RequestBody SportClub sportClub){
        return userService.addSportClub(sportClub);
    }

   

}
