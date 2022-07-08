package com.video_game.video_game
.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.video_game.video_game.dto.ConsoleDTO;
import com.video_game.video_game.dto.NewConsoleDTO;
import com.video_game.video_game.exceptions.ResourceNotFoundException;
import com.video_game.video_game.models.Console;
import com.video_game.video_game.repositories.ConsoleRepository;
import com.video_game.video_game.services.ConsoleService;


@Service
public class ConsoleServiceImpl implements ConsoleService{
    final ModelMapper modelMapper;
    final ConsoleRepository consoleRepository;

    @Autowired
    public ConsoleServiceImpl(@Autowired ConsoleRepository repository, ModelMapper mapper){
        this.consoleRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public ConsoleDTO create(NewConsoleDTO consoleDTO){
        Console console = modelMapper.map(consoleDTO, Console.class);
        consoleRepository.save(console);
        return modelMapper.map(console,ConsoleDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ConsoleDTO retrieve(Long id) {
        Console console = consoleRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Supply not found"));
        return modelMapper.map(console, ConsoleDTO.class);
    }

    @Override
    @Transactional
    public ConsoleDTO update(ConsoleDTO consoleDTO, Long id) {
        Console console = consoleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supply not found"));
        console.setId(id);
        console = modelMapper.map(consoleDTO, Console.class);
        consoleRepository.save(console);

        return modelMapper.map(console, ConsoleDTO.class);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        Console console = consoleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Supply not found"));
        consoleRepository.deleteById(console.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ConsoleDTO> list() {
        List<Console> consoles = consoleRepository.findAll();
        return consoles.stream().map(console -> modelMapper.map(console, ConsoleDTO.class)).collect(Collectors.toList());
    }
    
}
