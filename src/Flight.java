import java.io.Serializable;
import java.util.Arrays;

public class Flight implements Serializable {
    private String flightCode;
    private String origin;
    private String destination;
    private String date;
    private String time;
    private int chairs;
    private int chairsStatus;
    private boolean [] chairsMap;
    private double ticketPrice;

    public Flight(String flightCode, String origin, String destination, String date, String time, double ticketPrice) {
        this.flightCode = flightCode;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.chairs = 36;
        this.chairsStatus = 36;
        this.chairsMap = new boolean[36];
        Arrays.fill(this.chairsMap, false);
        this.ticketPrice = ticketPrice;
        this.flightStatus = "ativo";
    }

    private String flightStatus;

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getChairs() {
        return chairs;
    }

    public void setChairs(int chairs) {
        this.chairs = chairs;
    }

    public int getChairsStatus() {
        return chairsStatus;
    }

    public void setChairsStatus(int chairsStatus) {
        this.chairsStatus = chairsStatus;
    }

    public boolean[] getChairsMap() {
        return chairsMap;
    }

    public void setChairsMap(boolean[] chairsMap) {
        this.chairsMap = chairsMap;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }
}
