import java.util.Scanner;

public class Main {
    private static void clientMenu(ClientModule clientModule, Scanner in) {
        int option;
        do {
            System.out.println("Modulo cliente:");
            System.out.println("Escolha uma opcao:\n1-Cadastrar\n2-Alterar\n3-Exibir\n4-Remover\n5-Voltar ao Menu Principal");
            option = in.nextInt();
            in.nextLine();
            switch (option) {
                case 1:
                    clientModule.addClient();
                    break;
                case 2:
                    clientModule.editClient();
                    break;
                case 3:
                    clientModule.showClient();
                    break;
                case 4:
                    clientModule.deleteClient();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opcao invalida. Digite novamente.");
            }
        } while(option != 5);

    }

    private static void flightMenu(FlightModule flightModule, Scanner in) {
        int option;
        do {
            System.out.println("Escolha uma opcao:\n1-Cadastrar\n2-Alterar\n3-Exibir\n4-Remover");
            option = in.nextInt();
            in.nextLine();
        } while(option > 4 || option < 1);
        switch (option) {
            case 1:
                flightModule.addFlight();
                break;
            case 2:
                flightModule.changeFlightPrice();
                break;
            case 3:
                flightModule.findFlight();
                break;
            case 4:
                flightModule.removeFlight();
                break;
        }
    }

    private static void ticketMenu(TicketModule ticketModule, Scanner in) {
//        int option;
//        do {
//            System.out.println("Escolha uma opcao:\n1-Vender\n2-Consultar passagem\n3-Exibir\n4-Remover");
//            option = in.nextInt();
//            in.nextLine();
//        } while(option > 4 || option < 1);
//        switch (option) {
//            case 1:
//                flightModule.addFlight();
//                break;
//            case 2:
//                flightModule.changeFlightPrice();
//                break;
//            case 3:
//                flightModule.findFlight();
//                break;
//            case 4:
//                flightModule.removeFlight();
//                break;
//        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ClientModule clientModule = new ClientModule();
        FlightModule flightModule = new FlightModule();
        TicketModule ticketModule = new TicketModule();
        int option;
        do{
            System.out.println("Menu Principal");
            System.out.println("Escolha uma opcao:\n1-Clientes\n2-Voos\n3-Passagens\n4-Salvar e sair");
            option = in.nextInt();
            switch (option){
                case 1:
                    clientMenu(clientModule, in);
                    break;
                case 2:
                    flightMenu(flightModule, in);
                    break;
                case 3:
            }
        }while(option!= 4);
        Flight f;
    }
}
