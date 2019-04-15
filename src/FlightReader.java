import java.text.DateFormat;
import java.util.Scanner;

public class FlightReader {

    public String[] places = {"Recife", "Fortaleza", "Natal", "Vitória", "Rio de Janeiro", "Porto Alegre"};

    public String readFlightCode() {
        String val;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o codigo do voo: ");
        while (true) {
            val = in.nextLine();
            if (FlightValidator.isValidFlight(val)) {
                return val;
            }
            System.out.println("Codigo de voo invalido. Digite novamente: ");
        }

    }

    public String readFlightOrigin() {
        int val;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite a origem do voo: ");
        while (true) {
            for (int i = 0; i < places.length; i++) {
                System.out.println((i + 1) + " - " + places[i]);
            }
            val = in.nextInt();
            in.nextLine();
            if (val > 0 && val <= places.length) {
                return places[val - 1];
            }
            System.out.println("Local de Origem invalido. Digite novamente: ");
        }
    }

    public String readFlightDestination(String origin) {
        int val, ignore = -1;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o destino do voo: ");
        while (true) {
            for (int i = 0; i < places.length; i++) {
                if (origin.equals(places[i])) {
                    ignore = i;
                } else {
                    System.out.println((i + 1) + " - " + places[i]);
                }
            }
            val = in.nextInt();
            if ((val > 0 && val <= places.length) && val != ignore) {
                return places[val - 1];
            }
            System.out.println("Local de Destino invalido. Digite novamente: ");
        }
    }

    public String readDate() {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite a data do voo: ");
        String date;
        while (true) {
            date = in.nextLine();
            if (FlightValidator.isValidDate(date)) {
                return date;
            }
            System.out.println("Data invalida. Digite novamente: ");
        }
    }

    public String readTime() {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite a hora do voo: ");
        String time;
        while (true) {
            time = in.nextLine();
            if (FlightValidator.isValidTime(time)) {
                return time;
            }
            System.out.println("Hora invalida. Digite novamente: ");
        }
    }

    public double readTicketPrice() {
        double val;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o preco passagem do voo: ");
        while (true) {
            val = in.nextDouble();
            if (FlightValidator.isValidPrice(val)) {
                return val;
            }
            System.out.println("Preco invalido. Digite novamente: ");
        }
    }
}
