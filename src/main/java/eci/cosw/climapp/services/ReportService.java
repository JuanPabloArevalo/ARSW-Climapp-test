package eci.cosw.climapp.services;

import eci.cosw.climapp.models.Report;

import java.util.List;

public interface ReportService {
    /**
     * @param rep
     */
    public Report createReport(Report rep) throws ServicesException;

    /**
     * @param id
     */
    public void deleteReport(int id);

    /**
     */
    public void updateReport();

    /**
     * @return
     */
    public List<Report> getReports();


}
