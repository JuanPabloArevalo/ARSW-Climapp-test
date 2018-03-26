package eci.cosw.climapp.restController;


import eci.cosw.climapp.models.Report;
import eci.cosw.climapp.models.User;
import eci.cosw.climapp.services.ReportService;
import eci.cosw.climapp.services.ServicesException;
import eci.cosw.climapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "reports" )
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private UserService userService;

    @RequestMapping( value = "/newreport/{lat}&{lon}", method = RequestMethod.POST )
    public Report createReport(@RequestBody Report report, @PathVariable("lat") String lat,@PathVariable("lon") String lon) throws ServicesException {
        report.getCoordinate().setLatitude(Double.parseDouble(lat));
        report.getCoordinate().setLongitude(Double.parseDouble(lon));
        User u = userService.getUser(report.getReportedUser().getId());
        u.getReports().add(report);
        System.out.println(report.toString());
        return reportService.createReport(report);
    }

    @RequestMapping( value = "/", method = RequestMethod.GET )
    public List<Report> getReports() {
        return reportService.getReports();
    }

}
