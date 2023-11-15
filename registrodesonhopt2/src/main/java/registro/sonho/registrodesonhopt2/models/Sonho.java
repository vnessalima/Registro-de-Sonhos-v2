package registro.sonho.registrodesonhopt2.models;
import jakarta.persistence.*;

@Entity
@Table (name = "sonho")
public class Sonho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tema;
    @Column(nullable = false)

    private String descricao;
    @Column(nullable = false)

    private String data;
    @Column(nullable = false)

    private String hora;
    @Column(nullable = false)

    private String emocoes;

    @ManyToOne
    @JoinColumn(name = "usuario_id")  
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "historico_id") 
    private Historico historico;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getEmocoes() {
        return emocoes;
    }
    public void setEmocoes(String emocoes) {
        this.emocoes = emocoes;
    }
}