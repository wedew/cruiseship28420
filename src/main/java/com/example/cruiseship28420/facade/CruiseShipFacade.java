package com.example.cruiseship28420.facade;
import com.example.cruiseship28420.Exception.allNumbersMustBePositive;
import com.example.cruiseship28420.Exception.alreadyExsistNameException;
import com.example.cruiseship28420.Exception.cannotFindShipException;
import com.example.cruiseship28420.beans.CruiseShip;
import com.example.cruiseship28420.db.cruiseShipsRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class CruiseShipFacade {
    private cruiseShipsRepository cruiseShipsRepo;
    public CruiseShipFacade(cruiseShipsRepository cruiseShipsRepo) {
        this.cruiseShipsRepo = cruiseShipsRepo;
    }

    public void addShip(CruiseShip cruiseShip) throws alreadyExsistNameException, allNumbersMustBePositive {
        if(cruiseShip.getNumberOfPools()<0 || cruiseShip.getNumberOfRooms()<0)
            throw new allNumbersMustBePositive();
        for (CruiseShip ships: cruiseShipsRepo.findAll()) {
             if(ships.getName().equalsIgnoreCase(cruiseShip.getName()))
                 throw new alreadyExsistNameException();
        }
        cruiseShipsRepo.save(cruiseShip);
    }

    public void updateShip(CruiseShip cruiseShip) throws allNumbersMustBePositive, cannotFindShipException, alreadyExsistNameException {
        if(cruiseShip.getNumberOfPools()<0 || cruiseShip.getNumberOfRooms()<0)
            throw new allNumbersMustBePositive();
        CruiseShip ship = cruiseShipsRepo.findById(cruiseShip.getId()).orElseThrow(cannotFindShipException::new);
        if(!cruiseShip.getName().equalsIgnoreCase(ship.getName())){
            for (CruiseShip ships: cruiseShipsRepo.findAll()) {
                if(cruiseShip.getName().equalsIgnoreCase(ships.getName()))
                    throw new alreadyExsistNameException();
            }
        }
        cruiseShipsRepo.save(cruiseShip);
    }

    public void deleteShip(int shipId){
        cruiseShipsRepo.deleteById(shipId);
    }
    public List<CruiseShip> getAllShips(){
        return cruiseShipsRepo.findAll();
    }
    public CruiseShip getOneShip(String shipName){
        return cruiseShipsRepo.findByName(shipName);
    }

}
