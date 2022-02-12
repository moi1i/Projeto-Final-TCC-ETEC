package br.com.pinguins.tcc.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Lembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLembrete", unique = true, nullable = false)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String titulo;

    @Column(nullable = false)
    private LocalDate notificacao;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user"))
    private Usuario usuario;

    public Lembrete(){}

    public Lembrete(Integer id, String titulo, LocalDate notificacao, String descricao, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.notificacao = notificacao;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(LocalDate notificacao) {
        this.notificacao = notificacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUser() {
        return usuario;
    }

    public void setUser(Usuario user) {
        this.usuario = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lembrete lembrete = (Lembrete) o;
        return Objects.equals(id, lembrete.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
