package com.parlatech.map.dto;

import com.parlatech.map.domain.Equipamento;
import com.parlatech.map.domain.Ponto;

import java.io.Serializable;

public class EquipamentoDTO implements Serializable {



    private Integer idEquipamento;

    private Ponto ponto;

    public EquipamentoDTO(){

    }

    public EquipamentoDTO(Equipamento obj){
        this.setIdEquipamento(obj.getIdEquipamento());
        this.setPonto(obj.getPonto());
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
