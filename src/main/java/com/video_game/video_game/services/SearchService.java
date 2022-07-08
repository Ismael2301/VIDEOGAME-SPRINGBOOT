package com.video_game.video_game
.services;

import java.util.List;

import com.video_game.video_game.dto.NewSearchDTO;
import com.video_game.video_game.dto.SearchDTO;


public interface SearchService {
    
    public SearchDTO create(NewSearchDTO inquiryDTO);
    public SearchDTO retrieve(Long id);
    public SearchDTO update(SearchDTO inquiryDTO, Long id);
    public void delete(Long id);

    public List<SearchDTO> list();
}
