package registro.sonho.registrodesonhopt2.dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import registro.sonho.registrodesonhopt2.models.Usuario;
import java.util.List;

@Component
public interface UsuarioDAO extends CrudRepository<Usuario, Long> {

    // Buscar todos os usuários
    List<Usuario> findAll();

    // Buscar usuário por nome
    @Query("SELECT u FROM Usuario u WHERE u.nome = :nome")
    List<Usuario> findByNome(String nome);

    // Buscar usuário por login (por ex: vnsauro e senha: 1234)
    @Query("SELECT u FROM Usuario u WHERE u.login = :login")
    Usuario findByLogin(String login);

    List<Usuario> findByNomeStartingWithIgnoreCase(String nome);
}

//salvar novo usuario
//buscar todos os usuários
//buscar usuario por nome