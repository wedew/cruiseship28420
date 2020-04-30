package com.example.cruiseship28420.web;

import com.example.cruiseship28420.Exception.allNumbersMustBePositive;
import com.example.cruiseship28420.Exception.alreadyExsistNameException;
import com.example.cruiseship28420.Exception.cannotFindShipException;
import com.example.cruiseship28420.beans.CruiseShip;
import com.example.cruiseship28420.facade.CruiseShipFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ships")
public class CruiseShipController {

    private CruiseShipFacade shipFacade;
    public CruiseShipController(CruiseShipFacade shipFacade) {
        this.shipFacade = shipFacade;
    }

    @PostMapping
    public ResponseEntity<String> addShip(@RequestBody CruiseShip cruiseShip) throws alreadyExsistNameException, allNumbersMustBePositive {
        shipFacade.addShip(cruiseShip);
        return ResponseEntity.ok(cruiseShip.getName() + " registered!");
    }

    @PostMapping("/updateShip")
    public ResponseEntity<String> updateShip(@RequestBody CruiseShip cruiseShip) throws alreadyExsistNameException, allNumbersMustBePositive, cannotFindShipException {
        shipFacade.updateShip(cruiseShip);
        return ResponseEntity.ok(cruiseShip.getName() + " updated!");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteShip(@RequestParam int shipId){
        shipFacade.deleteShip(shipId);
        return ResponseEntity.ok("ship by id: " + shipId + " successfully deleted!");
    }

    @GetMapping("/all")
    public List<CruiseShip> getAllShips(){
        return shipFacade.getAllShips();
    }

    @GetMapping("/one")
    public ResponseEntity<?> getOneShip(String shipName){
        CruiseShip oneShip =  shipFacade.getOneShip(shipName);
        if(oneShip instanceof CruiseShip)
            return ResponseEntity.ok(oneShip);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ship does not found...");
    }



}
