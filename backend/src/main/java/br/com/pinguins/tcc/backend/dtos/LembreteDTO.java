package br.com.pinguins.tcc.backend.dtos;

import java.time.LocalDate;

public class LembreteDTO {

    private Integer id;
    private String titulo;
    private LocalDate data;
    private String descricao;

    public LembreteDTO(){}

    public LembreteDTO(Integer id, String titulo, LocalDate data, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.descricao = descricao;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
