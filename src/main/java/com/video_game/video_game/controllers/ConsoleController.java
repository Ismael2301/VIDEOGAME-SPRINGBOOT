package com.video_game.video_game
.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.video_game.video_game.dto.ConsoleDTO;
import com.video_game.video_game.dto.NewConsoleDTO;
import com.video_game.video_game.services.ConsoleService;

@RequestMapping("/console")
@RestController
public class ConsoleController {

    private final ConsoleService service;
  
    @Autowired
    public ConsoleController(ConsoleService srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<ConsoleDTO> create(@Valid @RequestBody NewConsoleDTO consoleDTO){
        ConsoleDTO result = service.create(consoleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsoleDTO> retrieve(@PathVariable("id") Long id){
        ConsoleDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<ConsoleDTO>> list(){
        List<ConsoleDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsoleDTO> update(@RequestBody ConsoleDTO consoleDTO, @PathVariable("id") Long id){
        ConsoleDTO result = service.update(consoleDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body("Console deleted!");        
    }
}