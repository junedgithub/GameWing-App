package com.ty.gamewingmanagementapp.controller;

import com.ty.gamewingmanagementapp.dto.PlayArea;
import com.ty.gamewingmanagementapp.dto.ResponseStructure;
import com.ty.gamewingmanagementapp.dto.User;
import com.ty.gamewingmanagementapp.service.PlayAreaService;
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
public class PlayAreaController {

    @Autowired
    private PlayAreaService playAreaService;

    @Operation(description = "Add PlayArea",summary = "PlayArea Details get added in database")
    @ApiResponses(value = {@ApiResponse(description = "PlayArea Added",responseCode = "302"),@ApiResponse(description = "Not Created",responseCode = "404")})
    @PostMapping("/saveplayarea")
    public ResponseEntity<ResponseStructure<PlayArea>> addPlayArea(@RequestBody PlayArea playArea){
        return playAreaService.addPlayArea(playArea);
    }

    @Operation(description = "Add PlayArea to SportClub",summary = "PlayArea added to SportClub")
    @ApiResponses(value = {@ApiResponse(description = "PlayArea Added to SportClub",responseCode = "302"),@ApiResponse(description = "Not Created",responseCode = "404")})
    @PostMapping("/addplayarea/playareaID/{areaId}/clubId/{clubId}")
    public ResponseEntity<ResponseStructure<PlayArea>> addPlayAreaToSportClub(@PathVariable int areaId,@PathVariable int clubId){
        return playAreaService.addPlayAreaToSportClub(areaId,clubId);
    }
}
