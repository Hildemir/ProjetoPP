public class FlightModule {
    private LinkedList<String, Flight> flights = new LinkedList();
    private FlightReader reader = new FlightReader();

    public void addFlight() {
        String flightCode = reader.readFlightCode();
        while (flights.containsKey(flightCode)) {
            System.out.print("Voo ja existente.");
            flightCode = reader.readFlightCode();
        }
        String origin = reader.readFlightOrigin();
        flights.put(flightCode, new Flight(flightCode, origin, reader.readFlightDestination(origin), reader.readDate(), reader.readTime(), reader.readTicketPrice()));
    }

    public void findFlight () {
        String origin = reader.readFlightOrigin(), destination = reader.readFlightDestination(origin), date = reader.readDate();
        Node<String, Flight> aux = flights.getHead();
        while (aux != null) {
            Flight flight = aux.getValue();
            if(flight.getOrigin().equals(origin) && flight.getDestination().equals(destination) && flight.getDate().equals(date) && flight.getChairsStatus() > 0 && flight.getFlightStatus().equals("ativo")){
                System.out.println("Codigo do voo: " + flight.getFlightCode());
                System.out.println("Hora do voo: " + flight.getTime());
                System.out.println("Poltronas disponiveis: " + flight.getChairsStatus());
            }
            aux = aux.getNext();
        }
    }

    public Flight getFlight() {
        String flightCode = reader.readFlightCode();
        while (!flights.containsKey(flightCode)) {
            System.out.print("Voo nao encontrado.");
            flightCode = reader.readFlightCode();
        }
        return flights.get(flightCode);
    }

    public void removeFlight() {
        flights.remove(getFlight().getFlightCode());
    }

    public void changeFlightPrice() {
        getFlight().setTicketPrice(reader.readTicketPrice());
    }


}
