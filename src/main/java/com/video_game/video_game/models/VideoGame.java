package com.video_game.video_game.models;

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
@Table(name="TBL_VIDEOGAMES")
@Getter
@Setter
public class VideoGame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="NAME",nullable = false)
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="AMOUNT")
    private String amount;

    @Column(name="QUANTITY")
    private String quantity;

    @ManyToOne
    @JoinColumn(name="CONSOLE_ID", nullable=false)
    private Console console;

    @ManyToOne
    @JoinColumn(name="PRODUCT_ID", nullable=false)
    private Category category;

}
