package registro.sonho.registrodesonhopt2.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import registro.sonho.registrodesonhopt2.models.Sonho;

import java.util.List;

@Repository
public interface SonhoDAO extends JpaRepository<Sonho, Long> {

    // Consulta por emoção e data
    @Query("SELECT s FROM Sonho s WHERE s.emocoes = :emocao AND s.data = :data")
    List<Sonho> findByEmocaoAndData(String emocao, String data);

    // Excluir sonho por ID
    void deleteById(Long id);

    List<Sonho> findByEmocaoIgnoreCase(String emocao);
}
//consultar sonho por emocao e data.
//excluir sonho com base no ID dele.