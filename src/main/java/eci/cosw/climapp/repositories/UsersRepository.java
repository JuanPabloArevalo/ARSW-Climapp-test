package eci.cosw.climapp.repositories;

import eci.cosw.climapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Laura Ramos
 */
public interface UsersRepository extends JpaRepository <User,Integer>{

    @Query()
    User finUserByEmail(String email);
}
