package com.video_game.video_game
.services;

import java.util.List;

import com.video_game.video_game.dto.NewVideoGameDTO;
import com.video_game.video_game.dto.VideoGameDTO;

public interface VideoGameService {
    
    public VideoGameDTO create(NewVideoGameDTO videoGameDTO);
    public VideoGameDTO retrieve(Long id);
    public VideoGameDTO update(VideoGameDTO videoGameDTO, Long id);
    public void delete(Long id);

    public List<VideoGameDTO> list();
}
