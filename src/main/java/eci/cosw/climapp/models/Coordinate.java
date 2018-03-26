package eci.cosw.climapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity(name= "Cordinate")
public class Coordinate implements java.io.Serializable {

//    @Id
//    @GeneratedValue
    private long id;
    private double latitude;
    private double longitude;

    /**
     * @param latitude
     * @param longitude
     */
    public Coordinate(long id,Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.id=id;
    }

    /**
     * @param latitude
     * @param longitude
     */
    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordinate(){

    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return Double.valueOf(latitude);
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(Double latitude) {
        this.latitude = Double.valueOf(latitude);
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return Double.valueOf(longitude);
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(Double longitude) {
        this.longitude = Double.valueOf(longitude);
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    public double distCoordenate(Coordinate otherCoordinate){
        double ratio = 6378.0F;//Km
        double dLat = Math.toRadians(Double.valueOf(otherCoordinate.getLatitude()) - Double.valueOf(this.getLatitude()));
        double dLng = Math.toRadians(Double.valueOf(otherCoordinate.getLongitude()) - Double.valueOf(this.getLongitude()));
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2) * Math.cos(Math.toRadians(Double.valueOf(this.getLatitude()))) * Math.cos(Math.toRadians(Double.valueOf(this.getLatitude())));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double dist = ratio * va2;
        System.out.println("Distance: "+dist);
        return dist;
    };
    @Override
    public String toString() {
        return "Coordinate{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

