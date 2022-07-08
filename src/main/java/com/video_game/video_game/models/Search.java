package com.video_game.video_game.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="TBL_SEARCHES")
@Getter
@Setter

public class Search {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DATE")    
    private Date date;

    @Column(name = "OBSERVATION")    
    private String observation;

    @ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
    private User user;


    @ManyToOne
    @JoinColumn(name="VIDEOGAME_ID", nullable=false)
    private VideoGame videoGame;

}
