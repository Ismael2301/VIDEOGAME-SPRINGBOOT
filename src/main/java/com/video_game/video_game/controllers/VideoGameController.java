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

import com.video_game.video_game
.dto.VideoGameDTO;
import com.video_game.video_game
.dto.NewVideoGameDTO;
import com.video_game.video_game
.services.VideoGameService;

@RequestMapping("/videoGame")
@RestController
public class VideoGameController {

    private final VideoGameService service;
  
    @Autowired
    public VideoGameController(VideoGameService srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<VideoGameDTO> create(@Valid @RequestBody NewVideoGameDTO videoGameDTO){
        VideoGameDTO result = service.create(videoGameDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoGameDTO> retrieve(@PathVariable("id") Long id){
        VideoGameDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<VideoGameDTO>> list(){
        List<VideoGameDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoGameDTO> update(@RequestBody VideoGameDTO videoGameDTO, @PathVariable("id") Long id){
        VideoGameDTO result = service.update(videoGameDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body("VideoGame deleted!");        
    }
}