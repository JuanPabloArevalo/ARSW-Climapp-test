package eci.cosw.climapp.services;


import eci.cosw.climapp.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {

    private List<Publication> publications= new ArrayList<>();

    @Autowired
    private ReportService reportsService;

    public PublicationServiceImpl(){
        Report r1= new Report(1,new Date (), new Coordinate( 4.710988599999999,-74.072092), "assets/img/rain", "comment", "rain",
                new User(4,"prueba4@mail.com","password","DFRT","http://www.your3dsource.com/images/facepic3.jpeg","password"),
                new Zone(11, 11, "Suba",
                        new ArrayList<Coordinate> (Arrays.asList(new Coordinate(4.836357, -74.084712), new Coordinate(4.828147, -74.033557), new Coordinate(4.741931, -74.134494), new Coordinate(4.686501, -74.057247)))));
        Report r2= new Report(2,new Date (), new Coordinate( 4.710988599999999,-74.072092), "assets/img/rain", "comment", "rain",
                new User(5,"prueba5@mail.com","password","DFRT2","http://www.your3dsource.com/images/facepic3.jpeg","password"),
                new Zone(11, 11, "Suba",
                        new ArrayList<Coordinate> (Arrays.asList(new Coordinate(4.836357, -74.084712), new Coordinate(4.828147, -74.033557), new Coordinate(4.741931, -74.134494), new Coordinate(4.686501, -74.057247)))));
        Report r3= new Report(2,new Date(), new Coordinate( 4.710988599999999,-74.072092), "assets/img/rain", "comment", "rain",
                new User(6,"prueba6@mail.com","password","DFRT3","http://www.your3dsource.com/images/facepic3.jpeg","password"),
                new Zone(11, 11, "Suba",
                        new ArrayList<Coordinate> (Arrays.asList(new Coordinate(4.836357, -74.084712), new Coordinate(4.828147, -74.033557), new Coordinate(4.741931, -74.134494), new Coordinate(4.686501, -74.057247)))));

        publications.add(new Publication(1, new ArrayList<Report>(Arrays.asList(r1,r2,r3)),new Zone(11, 11, "Suba",
                new ArrayList<Coordinate> (Arrays.asList(new Coordinate(4.836357, -74.084712), new Coordinate(4.828147, -74.033557), new Coordinate(4.741931, -74.134494), new Coordinate(4.686501, -74.057247))))));


    }


    @Override
    public List<Publication> getPublications() {
        return publications;
    }

    @Override
    public Publication createPublication(Publication p) {
        publications.add(p);
        p.setId(publications.size());
        return p;
    }

    @Override
    public List<Report> findNewPublication(Report rep) throws ServicesException{
        List<Report> reportPublications=new ArrayList<Report>();
        for (int i=0;i<reportsService.getReports().size();i++){
            Report repPublication= reportsService.getReports().get(i);
            if(rep.getCoordinate().distCoordenate(repPublication.getCoordinate())<=0.7 && rep.getWeather().equals(repPublication.getWeather())){
                reportPublications.add(repPublication);
            };
        }


        return reportPublications;
    }
    @Override
    public Publication findPublication(Report rep) throws ServicesException{
        for (int i=0;i<publications.size();i++){
            List<Report> reportPublications=publications.get(i).getReports();
            for (int j=0;j<reportPublications.size();j++){
                Report repPublication= reportPublications.get(j);
                if(rep.getCoordinate().distCoordenate(repPublication.getCoordinate())<=0.7 && rep.getWeather().equals(repPublication.getWeather())){
                    reportPublications.add(rep);
                    return publications.get(i);

                };
            }
        }

        return null;
    }
}