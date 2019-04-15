import java.util.Scanner;

public class ClientReader {

    public String readCpf() {
        String val;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o cpf do cliente: ");
        while (true) {
            val = in.nextLine();
            if (ClientValidator.isValidCpf(val)) {
                return val;
            }
            System.out.println("Cpf invalido. Digite novamente: ");
        }
    }

    public String readName() {
        String val;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        while (true) {
            val = in.nextLine();
            if (ClientValidator.isValidName(val)) {
                return val.replace("  ", " ").trim();
            }
            System.out.println("Nome invalido. Digite novamente: ");
        }
    }

    public String readPhone() {
        String val;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o telefone do cliente: ");
        while (true) {
            val = in.nextLine();
            if (ClientValidator.isValidPhone(val)) {
                return val;
            }
            System.out.println("Telefone invalido. Digite novamente: ");
        }
    }

    public String readEmail() {
        String val;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o email do cliente: ");
        while (true) {
            val = in.nextLine();
            if (ClientValidator.isValidEmail(val)) {
                return val;
            }
            System.out.println("Email invalido. Digite novamente: ");
        }
    }

    public int readOption(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}