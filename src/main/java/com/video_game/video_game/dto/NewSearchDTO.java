package com.video_game.video_game.dto;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewSearchDTO {
    
    private Date date;
    private String observation;

}
