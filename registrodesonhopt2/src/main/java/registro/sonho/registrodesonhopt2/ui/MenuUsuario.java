package registro.sonho.registrodesonhopt2.ui;

import registro.sonho.registrodesonhopt2.dao.UsuarioDAO;
import registro.sonho.registrodesonhopt2.models.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.List;

@Slf4j
@Component
public class MenuUsuario {

    @Autowired
    private UsuarioDAO usuarioDAO;

    public void obterNovoUsuario() {
        Usuario usuario = new Usuario();
        String nome = JOptionPane.showInputDialog("Nome");
        String login = JOptionPane.showInputDialog("Login");
        String email = JOptionPane.showInputDialog("Email");

        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setEmail(email);

        usuarioDAO.save(usuario);
    }

    public void exibirTodosUsuarios() {
        List<Usuario> usuarios = usuarioDAO.findAll();
        listaUsuarios(usuarios);
    }

    public void buscarUsuarioPorNome() {
        String nome = JOptionPane.showInputDialog("Digite o nome do usuário:");
        List<Usuario> usuarios = usuarioDAO.findByNomeStartingWithIgnoreCase(nome);
        listaUsuarios(usuarios);
    }

    private void listaUsuarios(List<Usuario> usuarios) {
        StringBuilder listagem = new StringBuilder();
        for (Usuario usuario : usuarios) {
            listagem.append(usuario.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum usuário encontrado" : listagem);
    }

    public void menu() {
        StringBuilder menu = new StringBuilder("Menu Usuários\n")
                .append("1 - Salvar Novo Usuário.\n")
                .append("2 - Buscar Todos os Usuários.\n") //lista de todos os usuarios
                .append("3 - Buscar Usuário pelo Nome.\n") //pra saber se o usuario realmente existe na plataforma
                .append("4 - Sair");

        char opcao = '0';
        do {
            try {
                opcao = JOptionPane.showInputDialog(menu).charAt(0);
                switch (opcao) {
                    case '1': // Salvar Novo Usuário
                        obterNovoUsuario();
                        break;
                    case '2': // Buscar Todos os Usuários
                        exibirTodosUsuarios();
                        break;
                    case '3': // Buscar Usuário pelo Nome
                        buscarUsuarioPorNome();
                        break;
                    case '4': // Sair
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida");
                        break;
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }

        } while (opcao != '4');
    }
}

//salvar novo usuario
//buscar todos os usuários
//buscar usuario por nome