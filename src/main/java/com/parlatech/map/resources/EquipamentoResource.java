package com.parlatech.map.resources;

import com.parlatech.map.domain.Equipamento;
import com.parlatech.map.dto.EquipamentoDTO;
import com.parlatech.map.services.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/equipamentos")
public class EquipamentoResource {

    @Autowired
    private EquipamentoService service;



    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Equipamento> find(@PathVariable Integer id) {
        Equipamento obj = service.findOne(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody EquipamentoDTO objDto) {
        Equipamento obj = service.fromDTO(objDto);
        obj = service.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdEquipamento()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody EquipamentoDTO objDto, @PathVariable Integer id) {
        Equipamento obj = service.fromDTO(objDto);
        obj.setIdEquipamento(id);
        obj = service.atualizar(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@Valid @RequestBody EquipamentoDTO objDto, @PathVariable Integer id) {
        objDto.setIdEquipamento(id);
        Equipamento obj = service.fromDTO(objDto);
        service.deletar(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<EquipamentoDTO>> findAll() {
        List<Equipamento> list = service.listar();
        List<EquipamentoDTO> listDto = list.stream().map(obj -> new EquipamentoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<EquipamentoDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {


        Page<Equipamento> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<EquipamentoDTO> listDto = list.map(obj -> new EquipamentoDTO(obj));

        return ResponseEntity.ok().body(listDto);
    }
}
