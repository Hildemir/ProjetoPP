public class Ticket {
    private Client client;
    private Flight flight;
    private String code;
    private int chair;
    private String statusReservation;

    public Ticket(Client client, Flight flight, String code, int chair) {
        this.client = client;
        this.flight = flight;
        this.code = code;
        this.chair = chair;
        this.statusReservation = "ativada";
    }

    public Client getClient() {
        return client;
    }

    public Flight getFlight() {
        return flight;
    }

    public String getCode() {
        return code;
    }

    public int getChair() {
        return chair;
    }

    public String getStatusReservation() {
        return statusReservation;
    }

    public void setStatusReservation(String statusReservation) {
        this.statusReservation = statusReservation;
    }
}
