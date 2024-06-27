package com.labdessoft.roteiro01.entity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
class TipoTarefa {
    int codigoTipoTarefa;
    String descricaoTipoTarefa;

    public TipoTarefa(int codigoTipoTarefa) {
        if (codigoTipoTarefa == 1) {
            this.codigoTipoTarefa = codigoTipoTarefa;
            this.descricaoTipoTarefa = "Data, (tem uma data prevista para a conclusão)";
        } else if (codigoTipoTarefa == 2) {
            this.codigoTipoTarefa = codigoTipoTarefa;
            this.descricaoTipoTarefa = "Prazo, (com prazo previsto de conclusão informado em dias)";
        } else if (codigoTipoTarefa == 3) {
            this.codigoTipoTarefa = codigoTipoTarefa;
            this.descricaoTipoTarefa = "Livro, (Sem data ou prazo previsto para conclusão)";
        } else {
            this.codigoTipoTarefa = 0;
            this.descricaoTipoTarefa = "Tipo de tarefa inválido!";
        }

    }

    public TipoTarefa() {

    }
}

@Embeddable
class PrioridadeTarefa {
    int codigoPrioridadeTarefa;
    String descricaoPrioridadeTarefa;

    public PrioridadeTarefa(int codigoPrioridadeTarefa) {
        if (codigoPrioridadeTarefa == 1) {
            this.codigoPrioridadeTarefa = codigoPrioridadeTarefa;
            this.descricaoPrioridadeTarefa = "Alta";
        } else if (codigoPrioridadeTarefa == 2) {
            this.codigoPrioridadeTarefa = codigoPrioridadeTarefa;
            this.descricaoPrioridadeTarefa = "Média";
        } else if (codigoPrioridadeTarefa == 3) {
            this.codigoPrioridadeTarefa = codigoPrioridadeTarefa;
            this.descricaoPrioridadeTarefa = "Baixa";
        } else {
            this.codigoPrioridadeTarefa = 0;
            this.descricaoPrioridadeTarefa = "Tipo de prioridade inválido!";
        }

    }

    public PrioridadeTarefa() {

    }
}

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Todos os detalhes de uma tarefa. ")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(name = "descricao")
    @Size(min = 10, message = "Descrição da tarefa deve possuir pelo menos 10 caracteres")
    private String descricao;
    private Boolean estaCompleta;
    private int tipoTarefa;
    private int prioridadeTarefa;
    // private int status;


    public Task(String descricao, Boolean estaCompleta, int tipoTarefa, int prioridadeTarefa) {
        this.descricao = descricao;
        this.estaCompleta = estaCompleta;
        this.tipoTarefa = tipoTarefa;
        this.prioridadeTarefa = prioridadeTarefa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", description=" + descricao + ", completed=" +
                descricao + "]";
    }
}