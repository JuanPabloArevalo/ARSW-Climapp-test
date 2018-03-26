/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.cosw.climapp.repositories;


import eci.cosw.climapp.models.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Laura Ramos
 */

public interface ZonesRepository extends JpaRepository <Zone,Integer >{

}
