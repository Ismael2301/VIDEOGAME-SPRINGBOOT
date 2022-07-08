package com.video_game.video_game
.services;

import java.util.List;
import com.video_game.video_game.dto.NewUserDTO;
import com.video_game.video_game.dto.UserDTO;

public interface UserService {

    public UserDTO create(NewUserDTO userDTo);
    public UserDTO retrieve(Long id);
    public UserDTO update(UserDTO userDTO, Long id);
    public void delete(Long id);

    public List<UserDTO> list();
}
