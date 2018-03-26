package eci.cosw.climapp.restController;

import eci.cosw.climapp.models.Publication;
import eci.cosw.climapp.models.Report;
import eci.cosw.climapp.services.PublicationService;
import eci.cosw.climapp.services.ReportService;
import eci.cosw.climapp.services.ServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "publications" )
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private SimpMessagingTemplate msgt;

    @RequestMapping( value = "/findpublication", method = RequestMethod.POST )
    public boolean findPublication(@RequestBody Report report) throws ServicesException {
        boolean flag=false;
        Publication p=null;
        List<Report> reports = publicationService.findNewPublication(report);
        if(reports.size()>=3){
            p=new Publication();
            p.setReports(reports);
            p.setZones(report.getZone());
            publicationService.createPublication(p);
            for (int i=0;i<reportService.getReports().size();i++){
                reportService.deleteReport(reports.get(i).getId());
            }
            flag=true;
            System.out.println("publicacion realizadaaaa");
        }else{
            p=publicationService.findPublication(report);
            if(p!=null){
                flag=true;
                reportService.deleteReport(report.getId());

            };

        }
        if(flag){
            //PUBLICAR ZONA
            msgt.convertAndSend("/topic/reportWeather", p);
            //Publicar Zona favorita
            int numberZone = report.getZone().getNumber();
            if(numberZone!=22){
                msgt.convertAndSend("/topic/zoneSuscribe"+numberZone, p);

            }
        }
        return flag;
    }

    @RequestMapping( value = "/", method = RequestMethod.GET )
    public List<Publication> getPublications(){
        return publicationService.getPublications();
    }

}
