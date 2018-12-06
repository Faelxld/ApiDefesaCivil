package com.parlatech.map.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Equipamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEquipamento;
    @OneToOne
    @JoinColumn(name = "ponto", referencedColumnName = "idPonto")
    private Ponto ponto;

    public Equipamento(){}

    public Equipamento(Integer idEquipamento, Ponto ponto){
        this.idEquipamento = idEquipamento;
        this.ponto = ponto;

    }

    public Integer getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Integer idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }
}
