package registro.sonho.registrodesonhopt2.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "historico")
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historico")
    private List<Sonho> sonhos;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public List<Sonho> getSonhos() {
        return sonhos;
    }
    public void setSonhos(List<Sonho> sonhos) {
        this.sonhos = sonhos;
    }
}