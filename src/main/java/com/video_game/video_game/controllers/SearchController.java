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

import com.video_game.video_game.dto.NewSearchDTO;
import com.video_game.video_game.dto.SearchDTO;
import com.video_game.video_game.services.SearchService;



@RequestMapping("/search")
@RestController
public class SearchController {

    private final SearchService service;
  
    @Autowired
    public SearchController(SearchService srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<SearchDTO> create(@Valid @RequestBody NewSearchDTO searchDTO){
        SearchDTO result = service.create(searchDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<SearchDTO> retrieve(@PathVariable("id") Long id){
        SearchDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<SearchDTO>> list(){
        List<SearchDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<SearchDTO> update(@RequestBody SearchDTO searchDTO, @PathVariable("id") Long id){
        SearchDTO result = service.update(searchDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body("Search deleted!");        
    }
}