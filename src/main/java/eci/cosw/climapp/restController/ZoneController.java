/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.cosw.climapp.restController;

import eci.cosw.climapp.services.ZoneService;
import eci.cosw.climapp.models.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author JuanArevaloMerchan
 */
@RestController
@RequestMapping( "zones" )
public class ZoneController {
    @Autowired
    private ZoneService zoneServices;
    
    @RequestMapping( value = "/", method = RequestMethod.GET )
    public List<Zone> getZones(){
        return zoneServices.getZones();
    }
}
