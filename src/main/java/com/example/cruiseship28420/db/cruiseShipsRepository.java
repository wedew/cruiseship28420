package com.example.cruiseship28420.db;

import com.example.cruiseship28420.beans.CruiseShip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cruiseShipsRepository extends JpaRepository<CruiseShip,Integer> {

    CruiseShip findByName(String shipName);

}
