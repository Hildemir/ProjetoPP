public class ClientModule {
    private LinkedList<String, Client> clients = new LinkedList();
    private ClientReader reader = new ClientReader();

    public void addClient() {
        String cpf = reader.readCpf();
        while(clients.containsKey(cpf)) {
            System.out.print("Cpf ja existente, tente de novo.");
            cpf = reader.readCpf();
        }
        Client client = new Client(cpf, reader.readName(), reader.readPhone(), reader.readEmail());
        clients.put(client.getCpf(), client);
    }

    public Client getClient() {
        String cpf = reader.readCpf();
        while(!clients.containsKey(cpf)) {
            System.out.print("Cpf nao encontrado, tente de novo.");
            cpf = reader.readCpf();
        }
        return clients.get(cpf);
    }

    public void showClient() {
        Client client = getClient();
        System.out.println("Cpf: " + client.getCpf());
        System.out.println("Nome: " + client.getName());
        System.out.println("Telefone: " + client.getPhone());
        System.out.println("Email: " + client.getEmail());
    }

    public void deleteClient() {
        Client client = getClient();
        clients.remove(client.getCpf());
    }

    public void editClient() {
        int choosen;
        Client client = getClient();
        do{
            System.out.println("Digite  a opcao que deseja alterar: ");
            System.out.println("1 - Telefone");
            System.out.println("2 - Email;");
            System.out.println("3 - Telefone e Email");
            System.out.println("4 - Voltar ao modulo cliente");
            choosen = reader.readOption();

            switch (choosen) {
                case 1:
                    client.setPhone(reader.readPhone());
                    return;
                case 2:
                    client.setEmail(reader.readEmail());
                    return;
                case 3:
                    client.setPhone(reader.readPhone());
                    client.setEmail(reader.readEmail());
                    return;
                case 4:
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");

            }
        }while(choosen != 4);
    }
}
