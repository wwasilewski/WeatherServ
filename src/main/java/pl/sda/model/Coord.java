//package pl.sda.model;
//
//import java.util.Objects;
//
//public class Coord {
//
//    private float lon; //longitude
//    private float lat; //latitude
//
//    public Coord(float lon, float lat) {
//        this.lon = lon;
//        this.lat = lat;
//    }
//
//    public float getLon() {
//        return lon;
//    }
//
//    public void setLon(float lon) {
//        this.lon = lon;
//    }
//
//    public float getLat() {
//        return lat;
//    }
//
//    public void setLat(float lat) {
//        this.lat = lat;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Coord coord = (Coord) o;
//        return getLon() == coord.getLon() && getLat() == coord.getLat();
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getLon(), getLat());
//    }
//
//    @Override
//    public String toString() {
//        return "Coord{" +
//                "lon=" + lon +
//                ", lat=" + lat +
//                '}';
//    }
//}
//