package com.ty.gamewingmanagementapp.controller;

import com.ty.gamewingmanagementapp.dto.ResponseStructure;
import com.ty.gamewingmanagementapp.dto.Slots;
import com.ty.gamewingmanagementapp.service.SlotsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/slots")
public class SlotsController {
    @Autowired
    private SlotsService slotsService;
    @Operation(description = "Add Slot",summary = "Slots get added in database")
    @ApiResponses(value = {@ApiResponse(description = "Add Slot",responseCode = "302"),@ApiResponse(description = "Not Created",responseCode = "404")})
    @PostMapping("/addslot/playareaId/{playAreaId}")
    public ResponseEntity<ResponseStructure<Slots>> addSlot(@RequestBody Slots slot,@PathVariable int playAreaId){
        return slotsService.saveSlot(slot,playAreaId);
    }

    @Operation(description = "Delete Slot",summary = "Slots details get deleted in database")
    @ApiResponses(value = {@ApiResponse(description = "Delete Slot",responseCode = "200"),@ApiResponse(description = "Not Deleted",responseCode = "404")})
    @PostMapping("/deleteslot/slotId/{slotId}")
    public ResponseEntity<ResponseStructure<Slots>> deleteslot(@PathVariable int slotId){
        return slotsService.deleteSlot(slotId);
    }

    @Operation(description = "Add Slot to PlayArea",summary = "Slots details get added in database")
    @ApiResponses(value = {@ApiResponse(description = "Slot is added to PlayArea",responseCode = "200"),@ApiResponse(description = "Not Added",responseCode = "404")})
    @PostMapping("/addslottoplayarea/slotId/{slotId}/playAreaId/{playAreaId}")
    public ResponseEntity<ResponseStructure<Slots>> addSlotToPlayArea(@PathVariable int slotId,@PathVariable int playAreaId){
        return slotsService.addSlotToPlayArea(slotId,playAreaId);
    }
}
