package com.video_game.video_game
.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.video_game.video_game.dto.CategoryDTO;
import com.video_game.video_game.dto.NewCategoryDTO;
import com.video_game.video_game.exceptions.ResourceNotFoundException;
import com.video_game.video_game.models.Category;
import com.video_game.video_game.repositories.CategoryRepository;
import com.video_game.video_game.services.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService{
    final ModelMapper modelMapper;
    final CategoryRepository maintenanceRepository;

    @Autowired
    public CategoryServiceImpl(@Autowired CategoryRepository repository, ModelMapper mapper){
        this.maintenanceRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public CategoryDTO create(NewCategoryDTO maintenanceDTO){
        Category maintenance = modelMapper.map(maintenanceDTO, Category.class);
        maintenanceRepository.save(maintenance);
        return modelMapper.map(maintenance,CategoryDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public CategoryDTO retrieve(Long id) {
        Category maintenance = maintenanceRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Maintenance not found"));
        return modelMapper.map(maintenance, CategoryDTO.class);
    }

    @Override
    @Transactional
    public CategoryDTO update(CategoryDTO maintenanceDTO, Long id) {
        Category maintenance = maintenanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Maintenance not found"));
        maintenance.setId(id);
        maintenance = modelMapper.map(maintenanceDTO, Category.class);
        maintenanceRepository.save(maintenance);

        return modelMapper.map(maintenance, CategoryDTO.class);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        Category maintenance = maintenanceRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Maintenance not found"));
        maintenanceRepository.deleteById(maintenance.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> list() {
        List<Category> maintenances =maintenanceRepository.findAll();
        return maintenances.stream().map(maintenance -> modelMapper.map(maintenance,CategoryDTO.class)).collect(Collectors.toList());
    }

    
}
