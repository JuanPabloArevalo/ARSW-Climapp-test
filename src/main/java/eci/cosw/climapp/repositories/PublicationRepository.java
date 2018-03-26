package eci.cosw.climapp.repositories;

import eci.cosw.climapp.models.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Laura Ramos
 */
public interface PublicationRepository extends JpaRepository <Publication, Integer>{
}
