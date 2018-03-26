package eci.cosw.climapp.services;

import eci.cosw.climapp.models.Coordinate;
import eci.cosw.climapp.models.Report;
import eci.cosw.climapp.models.User;
import eci.cosw.climapp.models.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by laura on 11/02/2018.
 */
@Service
public class ReportServiceImpl implements ReportService{

    private List<Report>reports=new ArrayList<>();

    @Autowired
    private ZoneService zoneService;

    public ReportServiceImpl() throws ServicesException{
        reports.add(new Report(1,new Date(),new Coordinate( 4.710988599999999,-74.072092), "assets/img/rain","comment", "rain",
                new User(3,"prueba3@mail.com","password","natan ram","http://www.your3dsource.com/images/facepic3.jpeg","password"),
                new Zone(11, 11, "Suba",
                        new ArrayList<Coordinate> (Arrays.asList(new Coordinate(4.836357, -74.084712), new Coordinate(4.828147, -74.033557), new Coordinate(4.741931, -74.134494), new Coordinate(4.686501, -74.057247))))));
        reports.add(new Report(2,new Date(),new Coordinate( 4.711777486983153,-74.07104712948808), "assets/img/rain","comment", "rain",
                new User(4,"prueba4@mail.com","password","daniel ro","http://www.your3dsource.com/images/facepic4.jpeg","password"),
                new Zone(11, 11, "Suba",
                        new ArrayList<Coordinate> (Arrays.asList(new Coordinate(4.836357, -74.084712), new Coordinate(4.828147, -74.033557), new Coordinate(4.741931, -74.134494), new Coordinate(4.686501, -74.057247))))));
    }

    @Override
    public Report createReport(Report rep) throws ServicesException{
        for(int i=0;i<zoneService.getNumZones();i++){
            if(this.containsZone(rep.getCoordinate().getLongitude(),rep.getCoordinate().getLatitude(),
                    zoneService.getZones().get(i).getCoordinates().size(),zoneService.getZones().get(i).getCoordinates())){
                rep.setZone(zoneService.getZones().get(i));
            }
        }
        for(int i=0; i<reports.size();i++){
            Report p=reports.get(i);
            if (rep.getReportedUser().getId()==p.getReportedUser().getId() && p.getCoordinate().distCoordenate(rep.getCoordinate())<=0.7) {
                if(p.getWeather().equals(rep.getWeather())){
                    throw new ServicesException("You have already published a report in the same zone with the same weather");
                }else if(!p.getWeather().equals(rep.getWeather()) && p.getDateTimeReport().compareTo(rep.getDateTimeReport())<8 ){
                    throw new ServicesException("You have recently published a report in the same zone with different weather conditions");
                }
            }
        }
        rep.setId(reports.size());
        reports.add(rep);
        return rep;
    }

    private boolean containsZone(Double x,Double y, int size, List<Coordinate> coord){
        boolean resp=false;
        int j,i;
        for(i=0,j=size-1;i<size;j=i++){
            if(((coord.get(i).getLatitude()) > y != (coord.get(j).getLatitude()>y)) &&
                    (x<(coord.get(j).getLongitude()-coord.get(i).getLongitude())*(y-coord.get(i).getLatitude())/
                            (coord.get(j).getLatitude()-coord.get(i).getLatitude())+coord.get(i).getLongitude())){
                resp =!resp;
            }
        }
        return resp;

    }
    @Override
    public void deleteReport(int id) {
        boolean flag=true;
        for (int i=0;i<reports.size() && flag;i++){
            Report rp=reports.get(i);
            if (id==rp.getId()){
                reports.remove(i);
                flag=false;
            }
        }
    }

    @Override
    public void updateReport() {

    }

    @Override
    public List<Report> getReports() {
        return reports;
    }



}
