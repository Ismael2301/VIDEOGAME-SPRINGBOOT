package com.video_game.video_game
.services;

import java.util.List;

import com.video_game.video_game.dto.CategoryDTO;

import com.video_game.video_game.dto.NewCategoryDTO;


public interface CategoryService {
    
    public CategoryDTO create(NewCategoryDTO categoryDTO);
    public CategoryDTO retrieve(Long id);
    public CategoryDTO update(CategoryDTO categoryDTO, Long id);
    public void delete(Long id);

    public List<CategoryDTO> list();
    
}
