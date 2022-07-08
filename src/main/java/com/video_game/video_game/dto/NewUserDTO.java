package com.video_game.video_game.dto;
import  java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewUserDTO {
    
    private String name;
    private String lastname;
    private String email;
    private String direction;
    private Date dateOfBirth;
}
