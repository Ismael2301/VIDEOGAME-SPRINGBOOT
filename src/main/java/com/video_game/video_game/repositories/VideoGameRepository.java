package com.video_game.video_game.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.video_game.video_game.models.VideoGame;

public interface VideoGameRepository extends JpaRepository<VideoGame,Long> {
    
}
