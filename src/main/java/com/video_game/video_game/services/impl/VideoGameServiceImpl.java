package com.video_game.video_game
.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.video_game.video_game.dto.NewVideoGameDTO;
import com.video_game.video_game.dto.VideoGameDTO;
import com.video_game.video_game.exceptions.ResourceNotFoundException;
import com.video_game.video_game.models.VideoGame;
import com.video_game.video_game.repositories.VideoGameRepository;
import com.video_game.video_game.services.VideoGameService;


@Service
public class VideoGameServiceImpl implements VideoGameService {
    final ModelMapper modelMapper;
    final VideoGameRepository videoGameRepository;

    @Autowired
    public VideoGameServiceImpl(@Autowired VideoGameRepository repository, ModelMapper mapper){
        this.videoGameRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public VideoGameDTO create(NewVideoGameDTO videoGameDTO){
        VideoGame videoGame = modelMapper.map(videoGameDTO, VideoGame.class);
        videoGameRepository.save(videoGame);
        return modelMapper.map(videoGame,VideoGameDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public VideoGameDTO retrieve(Long id) {
        VideoGame videoGame = videoGameRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Product not found"));
        return modelMapper.map(videoGame, VideoGameDTO.class);
    }

    @Override
    @Transactional
    public VideoGameDTO update(VideoGameDTO videoGameDTO, Long id) {
        VideoGame videoGame = videoGameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        videoGame.setId(id);
        videoGame = modelMapper.map(videoGameDTO, VideoGame.class);
        videoGameRepository.save(videoGame);

        return modelMapper.map(videoGame, VideoGameDTO.class);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        VideoGame videoGame = videoGameRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
        videoGameRepository.deleteById(videoGame.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<VideoGameDTO> list() {
        List<VideoGame> videoGames = videoGameRepository.findAll();
        return videoGames.stream().map(videoGame -> modelMapper.map(videoGame, VideoGameDTO.class)).collect(Collectors.toList());
    }
    
}
