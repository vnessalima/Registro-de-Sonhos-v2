package registro.sonho.registrodesonhopt2.ui;

import java.util.Scanner;

import registro.sonho.service.HistoricoService;

public class MenuHistorico {
    private Scanner scanner = new Scanner(System.in);
    private HistoricoService historicoService;  

    public MenuHistorico(HistoricoService historicoService) {
        this.historicoService = historicoService;
    }

    public class UsuarioNaoEncontradoException extends Exception {
        public UsuarioNaoEncontradoException(String mensagem) {
            super(mensagem);
        }
    }
    
    public void mostrarSonhosPorUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String nomeUsuario = scanner.nextLine();

        int quantidadeSonhos = historicoService.obterQuantidadeSonhosPorUsuario(nomeUsuario);
        System.out.println("Quantidade de sonhos cadastrados por " + nomeUsuario + ": " + quantidadeSonhos);
    }

    public void executar() {
        while (true) {
            System.out.println("Menu Histórico:");
            System.out.println("1. Mostrar sonhos por usuário");
            System.out.println("2. Voltar ao menu principal");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();  

            switch (escolha) {
                case 1:
                    mostrarSonhosPorUsuario();
                    break;
                case 2:
                    System.out.println("Voltando ao menu principal...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void menu() {
    }
}


/*mostre todos os sonhos de acordo com cada usuario cadastrado, ou seja, 
quando for fornecido o nome de usuario (pelo menu), mostrar quantos sonhos ele ja cadastrou,
 se nao tiver um usuario com esse nome dizer que o usuario nao foi encontrado
*/
