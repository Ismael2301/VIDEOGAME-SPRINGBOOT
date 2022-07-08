package com.video_game.video_game
.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.video_game.video_game.dto.NewSearchDTO;
import com.video_game.video_game.dto.SearchDTO;
import com.video_game.video_game.exceptions.ResourceNotFoundException;
import com.video_game.video_game.models.Search;
import com.video_game.video_game.repositories.SearchRepository;
import com.video_game.video_game.services.SearchService;


@Service
public class SearchServiceImpl implements SearchService{
    final ModelMapper modelMapper;
    final SearchRepository searchRepository;

    @Autowired // INYECTA LAS DEPENDENCIAS
    public SearchServiceImpl(@Autowired SearchRepository repository, ModelMapper mapper){
        this.searchRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public SearchDTO create(NewSearchDTO searchDTO){
        Search search = modelMapper.map(searchDTO, Search.class);
        searchRepository.save(search);
        return modelMapper.map(search,SearchDTO.class);
    }


    
    @Override
    @Transactional(readOnly = true)
    public SearchDTO retrieve(Long id) {
        Search search = searchRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Inquiry not found"));
        return modelMapper.map(search, SearchDTO.class);
    }

    @Override
    @Transactional
    public SearchDTO update(SearchDTO searchDTO, Long id) {
        Search search = searchRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Inquiry not found"));
        search.setId(id);
        search = modelMapper.map(searchDTO, Search.class);
        searchRepository.save(search);

        return modelMapper.map(search, SearchDTO.class);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        Search search = searchRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Inquiry not found"));
        searchRepository.deleteById(search.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<SearchDTO> list() {
        List<Search> searchs = searchRepository.findAll();
        return searchs.stream().map(search -> modelMapper.map(search, SearchDTO.class)).collect(Collectors.toList());
    }
}
