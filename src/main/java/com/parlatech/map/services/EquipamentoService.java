package com.parlatech.map.services;

import com.parlatech.map.domain.Equipamento;
import com.parlatech.map.dto.EquipamentoDTO;
import com.parlatech.map.repositories.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {
    @Autowired
    public EquipamentoRepository repository;


    public Equipamento findOne(Integer id ){

        return repository.findById(id).get();

    }

    public List<Equipamento> listar(){

        return repository.findAll();

    }

    public void deletar(Equipamento equipamento){
        repository.delete(equipamento);
    }

    public Equipamento salvar(Equipamento equipamento){
        return repository.save(equipamento);
    }

    public Equipamento atualizar(Equipamento equipamento){
        return repository.saveAndFlush(equipamento);
    }

    public Page<Equipamento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
    public Equipamento fromDTO(EquipamentoDTO objDto) {
        return new Equipamento(objDto.getIdEquipamento(), objDto.getPonto());
    }


}
