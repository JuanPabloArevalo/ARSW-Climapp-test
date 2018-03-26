package eci.cosw.climapp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by laura on 11/02/2018.
 */
//@Entity(name="User")
//@Table(name = "User")
public class User implements java.io.Serializable{

//    @Id
//    @GeneratedValue
    private int id;

//    @Column(name = "name", nullable = false, length = 100)
    private String name;

//    @Column(name = "email", nullable = false, length = 100)
    private String email;

//    @Column(name = "password", nullable = false, length = 100)
    private String password;

//    @Column(name = "confpasswd", nullable = false, length = 100)
    private String confirmPassword;

    private String image;
    private List<Report> reports = new ArrayList<>();
    private List<Zone> zones = new ArrayList<>();

    public User() {
    }

    /**
     *
     * @param email
     * @param password
     * @param name
     * @param image
     * @param confirmPassword
     */
    public User( String email, String password, String name, String image, String confirmPassword ) {
        this.email = email;
        this.password = password;
        this.image = image;
        this.name = name;
        this.confirmPassword = confirmPassword;
    }
    /**
     *
     * @param id
     * @param email
     * @param password
     * @param name
     * @param image
     * @param confirmPassword
     */
    public User(int id,String email, String password, String name, String image, String confirmPassword ) {
        this.email = email;
        this.password = password;
        this.image = image;
        this.name = name;
        this.confirmPassword = confirmPassword;
        this.id=id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @return the reports
     */
    public List<Report> getReports() {
        return reports;
    }

    /**
     * @param reports the reports to set
     */
    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    
    
    
    @Override
    public String toString() {
        return "User{" + "id=" + getId() + ", email='" + getEmail() + '\'' + ", password='" + getPassword() + '\'' + ", firstname='"
                + name + '\'' + '}';
    }

    /**
     * @return the zones
     */
    public List<Zone> getZones() {
        return zones;
    }

    /**
     * @param zones the zones to set
     */
    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }
    
    /**
     * Add zone to array
     * @param zone 
     */
    public void addZone(Zone zone){
        zones.add(zone);
    }
    
    /**
     * Delete zone of array
     * @param zone 
     */
    public void deleteZone(Zone zone){
        zones.remove(zone);
    }
}
