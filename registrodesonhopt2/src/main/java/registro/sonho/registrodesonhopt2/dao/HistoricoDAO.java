package registro.sonho.registrodesonhopt2.dao;
import registro.sonho.registrodesonhopt2.models.Historico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface HistoricoDAO extends JpaRepository<Historico, Integer> {

    @Query("SELECT h.usuario.nome, COUNT(h) FROM Historico h WHERE h.usuario.nome = :nomeUsuario GROUP BY h.usuario.nome")
    Object[] contarSonhosPorUsuario(String nomeUsuario);

    List<Historico> findHistoricoByNomeUsuario(String nomeUsuario);
}

//mostra quantos sonhos o usuario ja cadastrou.