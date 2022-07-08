package com.video_game.video_game
.services;

import java.util.List;

import com.video_game.video_game.dto.ConsoleDTO;
import com.video_game.video_game.dto.NewConsoleDTO;


public interface ConsoleService {
    public ConsoleDTO create(NewConsoleDTO consoleDTO);
    public ConsoleDTO retrieve(Long id);
    public ConsoleDTO update(ConsoleDTO consoleDTO, Long id);
    public void delete(Long id);

    public List<ConsoleDTO> list();
    
}
