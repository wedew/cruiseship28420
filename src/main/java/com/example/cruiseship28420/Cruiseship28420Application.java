package com.example.cruiseship28420;

import com.example.cruiseship28420.Exception.allNumbersMustBePositive;
import com.example.cruiseship28420.Exception.alreadyExsistNameException;
import com.example.cruiseship28420.Exception.cannotFindShipException;
import com.example.cruiseship28420.beans.CruiseShip;
import com.example.cruiseship28420.facade.CruiseShipFacade;
import org.aspectj.weaver.ast.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Cruiseship28420Application {

    public static void main(String[] args) {
        //        ConfigurableApplicationContext ctx =
        SpringApplication.run(Cruiseship28420Application.class, args);

//        CruiseShipFacade CruiseShipFacade = ctx.getBean(CruiseShipFacade.class);


//        try {
//            CruiseShipFacade.addShip(new CruiseShip("test", 2, 42));
//        } catch (alreadyExsistNameException | allNumbersMustBePositive e) {
//            System.out.println(e.getMessage());
//        }

//        CruiseShip ship = CruiseShipFacade.getOneShip("oceanic");
//        ship.setNumberOfPools(5);
//        try {
//            CruiseShipFacade.updateShip(ship);
//        } catch (alreadyExsistNameException | allNumbersMustBePositive | cannotFindShipException e) {
//            System.out.println(e.getMessage());
//        }

//        CruiseShipFacade.deleteShip(3);


//        for (CruiseShip ships: CruiseShipFacade.getAllShips()) {
//            System.out.println(ships);
//        }


//        System.out.println(CruiseShipFacade.getOneShip("titanic"));

    }

}
