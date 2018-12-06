package com.parlatech.map.services;

import com.parlatech.map.domain.Ponto;
import com.parlatech.map.repositories.PontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PontoService  {

    @Autowired
    public PontoRepository repository;


    public Ponto findOne(Integer id ){

        return repository.findById(id).get();

    }

    public List<Ponto> listar(){

        return repository.findAll();

    }

    public void deletar(Ponto ponto){
        repository.delete(ponto);
    }

    public Ponto salvar(Ponto ponto){
        return repository.save(ponto);
    }

    public Ponto atualizar(Ponto ponto){
        return repository.saveAndFlush(ponto);
    }



}
