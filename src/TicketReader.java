import java.util.Scanner;

public class TicketReader {
    public String readChair() {
        Scanner in = new Scanner(System.in);
        String chair;
        System.out.println("Digite a poltrona:");
        while(true) {
            chair = in.nextLine();
            if (TicketValidator.isValidChair(chair)){
                return chair;
            }
            System.out.println("Poltrona invalida. Digite novamente.");
        }
    }
}
