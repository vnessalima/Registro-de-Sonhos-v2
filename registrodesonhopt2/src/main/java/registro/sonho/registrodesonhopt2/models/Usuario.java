package registro.sonho.registrodesonhopt2.models;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.*;

@Entity
@EntityScan(basePackages = "registro.sonho.registrodesonhopt2.models")
@Table (name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String login;

    @OneToMany
    private List<Sonho> historico = new ArrayList<>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString(){
        return "Usuario [id= "+ id + ", nome=" + nome + ", login=" + login + "]";
    }
    public Object getEmail() {
        return null;
    }
    public void setEmail(String email) {
    }
}