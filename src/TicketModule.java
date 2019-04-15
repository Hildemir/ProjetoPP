import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class TicketModule {
    LinkedList<String, Ticket> tickets;
    ClientModule clientModule;
    FlightModule flightModule;
    private Random random = new SecureRandom();
    private String letters = "0123456789ABCDEF";
    TicketReader ticketReader;

    private String getNewCode() {
        char[] code = new char[8];
        for (int i = 0; i < code.length; i++) code[i] = letters.charAt(random.nextInt(letters.length()));
        return new String(code);
    }

    private static int chairToId(String chair) {
        return 6 * (chair.charAt(0) - '1') + chair.charAt(1) - 'A';
    }

    private static String idToChair(int i) {
        return "" + (i / 6 + 1) + ((char) ('A' + i % 6));
    }

    public void buyTicket() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        Client client = clientModule.getClient();
        Flight flight = flightModule.getFlight();
        while (flight.getChairsStatus() == 0) {
            System.out.print("Voo lotado. ");
            flight = flightModule.getFlight();
        }
        for (int i = 0; i < 36; i++) {
            if (!flight.getChairsMap()[i]) {
                System.out.println(idToChair(i));
            }
        }
        String chair = ticketReader.readChair();
        while (flight.getChairsMap()[chairToId(chair)]) {
            System.out.print("Poltrona escolhida esta ocupada. ");
            chair = ticketReader.readChair();
        }
        flight.getChairsMap()[chairToId(chair)] = true;
        flight.setChairsStatus(flight.getChairsStatus() - 1);
        String code = getNewCode();
        tickets.put(code, new Ticket(client, flight, code, chairToId(chair)));
        System.out.println("O codigo da reserva eh " + code);
        System.out.println("O valor pago foi R$ " + formatter.format(flight.getTicketPrice()));
    }

    public Ticket[] getTicketsFromClient(String cpf) {
        int cnt = 0;
        Node<String, Ticket> aux = tickets.getHead();
        while (aux != null) {
            if (aux.getValue().getClient().getCpf().equals(cpf)) {
                cnt++;
            }
            aux = aux.getNext();
        }
        Ticket[] ret = new Ticket[cnt];
        cnt = 0;
        aux = tickets.getHead();
        while (aux != null) {
            if (aux.getValue().getClient().getCpf().equals(cpf)) {
                ret[cnt++] = aux.getValue();
            }
            aux = aux.getNext();
        }
        return ret;
    }

    public void showTicketsFromClient(boolean showPast) {
        Client client = clientModule.getClient();
        Ticket[] clientTickets = getTicketsFromClient(client.getCpf());
        for (int i = 0; i < clientTickets.length; i++) {
            Ticket ticket = clientTickets[i];
            if (showPast || ticket.getFlight().getFlightStatus().equals("ativa")) {
                System.out.print("O codigo da reserva eh " + ticket.getCode());
                if (showPast) {
                    System.out.print(" status " + ticket.getFlight().getFlightStatus());
                }
                System.out.println();
            }
        }
    }

    public void cancelTicket(String ticketCode) {
        if (tickets.containsKey(ticketCode)) {
            Ticket ticket = tickets.get(ticketCode);
            ticket.setStatusReservation("cancelada");  // altera stayuis da reserva
            Flight flight = ticket.getFlight();
            flight.setChairsStatus(flight.getChairsStatus() + 1);
            flight.getChairsMap()[ticket.getChair()] = false;     //altera dados do voo + libera poltrona
            System.out.println("Passagem cancelada com sucesso!");
            System.out.println(" Codigo da passagem: " + ticketCode);
            System.out.println("Origem : " + ticket.getFlight().getOrigin());
            System.out.println("Destino : " + ticket.getFlight().getDestination());     // printar dados cancelamento
            System.out.println("Credito devido a cancelamento : R$" + (ticket.getFlight().getTicketPrice() / 2));             //valor de 50% da passagem de credito
        } else {
            System.out.println("Reserva nao existe.");
        }
        return;
    }

    public void getPasssengers(String flightCode) {
        if (flightModule.getFlight().equals(flightCode)) {

            int cnt = 0;
            Node<String, Ticket> aux = tickets.getHead();
            while (aux != null) {
                if (aux.getValue().getFlight().getFlightCode().equals(flightCode)) {
                    cnt++;
                }
                aux = aux.getNext();
            }
            Ticket[] flightPassengers = new Ticket[cnt];
            cnt = 0;
            aux = tickets.getHead();
            while (aux != null) {
                if (aux.getValue().getFlight().getFlightCode().equals(flightCode) && aux.getValue().getStatusReservation().equals("ativada")) {
                    flightPassengers[cnt++] = aux.getValue();
                }
                aux = aux.getNext();
            }

            for (int i = 0; i < flightPassengers.length; i++) {

                System.out.println("CPF:" + flightPassengers[i].getClient().getCpf());
                System.out.println("Nome:" + flightPassengers[i].getClient().getName());
                System.out.println("Poltrona:" + idToChair(flightPassengers[i].getChair()));
            }

        } else {
            System.out.println("Reserva nao existe.");
        }
    }
}
