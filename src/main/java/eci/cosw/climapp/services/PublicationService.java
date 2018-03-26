package eci.cosw.climapp.services;

import eci.cosw.climapp.models.Publication;
import eci.cosw.climapp.models.Report;

import java.util.List;

public interface PublicationService {

    public List<Publication> getPublications();

    public Publication createPublication(Publication p);

    public List<Report> findNewPublication(Report rep) throws ServicesException;

    public Publication findPublication(Report rep) throws ServicesException;
}
