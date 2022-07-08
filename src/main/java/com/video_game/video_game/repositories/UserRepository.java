package com.video_game.video_game
.repositories;


import com.video_game.video_game
.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
