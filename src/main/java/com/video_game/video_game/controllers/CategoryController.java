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

import com.video_game.video_game.dto.CategoryDTO;
import com.video_game.video_game.dto.NewCategoryDTO;
import com.video_game.video_game.services.CategoryService;

@RequestMapping("/category")
@RestController
public class CategoryController {

    private final CategoryService service;
  
    @Autowired
    public CategoryController(CategoryService srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<CategoryDTO> create(@Valid @RequestBody NewCategoryDTO categoryDTO){
        CategoryDTO result = service.create(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> retrieve(@PathVariable("id") Long id){
        CategoryDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<CategoryDTO>> list(){
        List<CategoryDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO categoryDTO, @PathVariable("id") Long id){
        CategoryDTO result = service.update(categoryDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body("Maintenance deleted!");        
    }
}