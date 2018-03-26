package eci.cosw.climapp.repositories;


import eci.cosw.climapp.models.Report;
import eci.cosw.climapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 * @author Laura Ramos
 */

public interface ReportsRepository extends JpaRepository <Report, Integer>{
    @Query("select name from User")
    public List<User> findClientByPPrice(long price);
}
