package eci.cosw.climapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name= "Publication")
public class Publication implements java.io.Serializable {

//    @Id
//    @GeneratedValue
    private int id;
    private List<Report> reports=new ArrayList<Report>();
    private Zone zones;

    public Publication(int id, List<Report> reports,Zone z) {
        this.id = id;
        this.reports = reports;
        this.zones=z;
    }

    public Publication(List<Report> reports,Zone z) {
        this.id = id;
        this.reports = reports;
        this.zones=z;
    }

    public Publication() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public Zone getZones() {
        return zones;
    }

    public void setZones(Zone zones) {
        this.zones = zones;
    }
}
