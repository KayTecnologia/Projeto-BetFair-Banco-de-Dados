package aplicacoes;

import entidades.*;
import servicos.*;
import java.util.Scanner;

public class Main {
    private static ServicoUsuario servicoUsuario = new ServicoUsuario();
    private static ServicoAposta servicoAposta = new ServicoAposta();
    private static ServicoEventoEsportivo servicoEvento = new ServicoEventoEsportivo();
    private static ServicoCarteira servicoCarteira = new ServicoCarteira();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            int opcao;
            try {
                opcao = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada inválida. Voltando ao menu.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();
            

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    cadastrarEvento();
                    break;
                case 4:
                    listarEventos();
                    break;
                case 5:
                    cadastrarAposta();
                    break;
                case 6:
                    listarApostas();
                    break;
                case 7:
                    adicionarFundosCarteira();
                    break;
                case 8:
                    listarCarteiras();
                    break;
                case 9:
                    atualizarUsuario();
                    break;
                case 10:
                    removerUsuario();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== BETFAIR - Casa de Apostas ===");
        System.out.println("1. Cadastrar Usuário");
        System.out.println("2. Listar Usuários");
        System.out.println("3. Cadastrar Evento Esportivo");
        System.out.println("4. Listar Eventos");
        System.out.println("5. Cadastrar Aposta");
        System.out.println("6. Listar Apostas");
        System.out.println("7. Adicionar Fundos à Carteira");
        System.out.println("8. Listar Carteiras");
        System.out.println("9. Atualizar Usuário");
        System.out.println("10. Remover Usuário");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarUsuario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Idade: ");
        int idade;
        try {
            idade = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Idade inválida. Operação cancelada.");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();

        Usuario usuario = new Usuario(nome, id, email, idade);
        servicoUsuario.cadastrar(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void listarUsuarios() {
        System.out.println("\nLista de Usuários:");
        for (Usuario usuario : servicoUsuario.listar()) {
            System.out.println(usuario.exibirInformacoes());
        }
    }

    private static void cadastrarEvento() {
        System.out.print("ID do Evento: ");
        String id = scanner.nextLine();
        System.out.print("Nome do Evento: ");
        String nome = scanner.nextLine();
        System.out.print("Data (dd/mm/aaaa): ");
        String data = scanner.nextLine();
        System.out.print("Esporte: ");
        String esporte = scanner.nextLine();

        EventoEsportivo evento = new EventoEsportivo(id, nome, data, esporte);
        servicoEvento.cadastrar(evento);
        System.out.println("Evento cadastrado com sucesso!");
    }

    private static void listarEventos() {
        System.out.println("\nLista de Eventos:");
        for (EventoEsportivo evento : servicoEvento.listar()) {
            System.out.println(evento.exibirEvento(true));
        }
    }

    private static void cadastrarAposta() {
        System.out.print("ID da Aposta: ");
        String idAposta = scanner.nextLine();
        System.out.print("ID do Usuário: ");
        String idUsuario = scanner.nextLine();
        System.out.print("ID do Evento: ");
        String idEvento = scanner.nextLine();
        System.out.print("Valor da Aposta: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Resultado Escolhido: ");
        String resultado = scanner.nextLine();

        Aposta aposta = new Aposta(idAposta, idUsuario, idEvento, valor, resultado);
        servicoAposta.cadastrar(aposta);
        System.out.println("Aposta cadastrada com sucesso!");
    }

    private static void listarApostas() {
        System.out.println("\nLista de Apostas:");
        for (Aposta aposta : servicoAposta.listar()) {
            System.out.println(aposta.detalhesAposta(true));
        }
    }

    private static void adicionarFundosCarteira() {
        System.out.print("ID do Usuário: ");
        String idUsuario = scanner.nextLine();
        System.out.print("Valor a adicionar: ");
        double valor;
        try {
            valor = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Valor inválido. Operação cancelada.");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();

        Carteira carteira = servicoCarteira.buscar(idUsuario);
        if (carteira == null) {
            carteira = new Carteira(idUsuario, valor);
            servicoCarteira.cadastrar(carteira);
        } else {
            carteira.adicionarFundos(valor);
            servicoCarteira.atualizar(carteira);
        }
        System.out.println("Fundos adicionados com sucesso!");
    }

    private static void listarCarteiras() {
        System.out.println("\nLista de Carteiras:");
        for (Carteira carteira : servicoCarteira.listar()) {
            System.out.println("Usuário ID: " + carteira.getIdUsuario() + ", Saldo: R$" + carteira.getSaldo());
        }
    }

    private static void atualizarUsuario() {
        System.out.print("ID do Usuário: ");
        String id = scanner.nextLine();
        Usuario usuario = servicoUsuario.buscar(id);
        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo Email: ");
        String email = scanner.nextLine();
        System.out.print("Nova Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setIdade(idade);
        servicoUsuario.atualizar(usuario);
        System.out.println("Usuário atualizado com sucesso!");
    }

    private static void removerUsuario() {
        System.out.print("ID do Usuário: ");
        String id = scanner.nextLine();
        servicoUsuario.remover(id);
        servicoCarteira.remover(id); // Remove carteira associada
        System.out.println("Usuário removido com sucesso!");
    }
}