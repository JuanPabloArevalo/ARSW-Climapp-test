package eci.cosw.climapp.repositories;

import eci.cosw.climapp.models.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Laura Ramos
 */

public interface CoordinatesRepository extends JpaRepository<Coordinate, Integer> {

}