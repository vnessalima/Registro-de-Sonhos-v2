package registro.sonho.registrodesonhopt2.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Component;

import javax.swing.JOptionPane;

@Component
public class MenuPrincipal implements CommandLineRunner {
    @Autowired
    private MenuUsuario menuUsuario;

    @Autowired
    private MenuSonho menuSonho;

    @Autowired
    private MenuHistorico menuHistorico;

    @Override
    public void run(String... args) {
        StringBuilder menu = new StringBuilder("Menu Principal\n")
                .append("1 - Usuários\n")
                .append("2 - Sonhos\n")
                .append("3 - Histórico de Sonhos\n")
                .append("4 - Sair");

        char opcao = '0';
        do {
            try {
                opcao = JOptionPane.showInputDialog(menu).charAt(0);
                switch (opcao) {
                    case '1':     // Usuários
                        menuUsuario.menu();
                        break;
                    case '2':     // Sonhos
                        menuSonho.menu();
                        break;
                    case '3':     // Histórico de Sonhos
                        menuHistorico.menu();
                        break;
                    case '4':     // Sair
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida");
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }

        } while (opcao != '4');
    }
 
    public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(MenuPrincipal.class);
		builder.headless(false).run(args);
	}
}

/*
consultas tipo:
JPQL
Native Query
Named Query
 */