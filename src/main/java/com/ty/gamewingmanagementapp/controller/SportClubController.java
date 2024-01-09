package com.ty.gamewingmanagementapp.controller;

import com.ty.gamewingmanagementapp.dto.PlayArea;
import com.ty.gamewingmanagementapp.dto.ResponseStructure;
import com.ty.gamewingmanagementapp.dto.SportClub;
import com.ty.gamewingmanagementapp.service.SportClubService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SportClubController {
    @Autowired
    private SportClubService sportClubService;

    @Operation(description = "Add SportClub",summary = "SportClub Details to database")
    @ApiResponses(value = {@ApiResponse(description = "Sport Club Created",responseCode = "302"),@ApiResponse(description = "Not Created",responseCode = "404")})
    @PostMapping("/addsportclub")
    public ResponseEntity<ResponseStructure<SportClub>> addSportClub(@RequestBody SportClub sportClub){
        return sportClubService.addSportClub(sportClub);
    }


}
