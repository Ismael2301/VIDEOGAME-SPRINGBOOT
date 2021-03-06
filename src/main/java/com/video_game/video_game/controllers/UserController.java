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

import com.video_game.video_game.dto.UserDTO;
import com.video_game.video_game.dto.NewUserDTO;
import com.video_game.video_game.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
  
    @Autowired
    public UserController(UserService srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<UserDTO> create(@Valid @RequestBody NewUserDTO userDTO){
        UserDTO result = service.create(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> retrieve(@PathVariable("id") Long id){
        UserDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<UserDTO>> list(){
        List<UserDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO, @PathVariable("id") Long id){
        UserDTO result = service.update(userDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body("User deleted!");        
    }
}