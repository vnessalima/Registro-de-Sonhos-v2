package registro.sonho.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registro.sonho.registrodesonhopt2.dao.HistoricoDAO;
import registro.sonho.registrodesonhopt2.models.Historico;

import java.util.List;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoDAO historicoDAO;

    public void exibirHistoricoPorNomeUsuario(String nomeUsuario) {
        List<Historico> historicoPorUsuario = historicoDAO.findHistoricoByNomeUsuario(nomeUsuario);

        if (historicoPorUsuario.isEmpty()) {
            System.out.println("Usuário não encontrado ou não possui histórico.");
        } else {
            System.out.println("Histórico para o usuário " + nomeUsuario + ":");
            for (Historico historico : historicoPorUsuario) {
                System.out.println("ID do Histórico: " + historico.getId());
                //acessar os sonhos associados a este historico 
                System.out.println("Sonhos associados: " + historico.getSonhos());
            }
        }
    }

    public int obterQuantidadeSonhosPorUsuario(String nomeUsuario) {
        return 0;
    }
}