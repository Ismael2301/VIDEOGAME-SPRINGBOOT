package com.video_game.video_game.models;

import  java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_USERS")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "NAME")    
    private String name;

    @Column(name = "LASTNAME")    
    private String lastname;

    @Column(name = "EMAIL")    
    private String email;

    @Column(name = "DIRECTION")    
    private String direction;

    @Column(name = "DATE_OF_BIRTH")    
    private Date dateOfBirth;

    @OneToMany(mappedBy="user") //nombre del atributo en la clase B       
    private List<Search> search; // esto me aparece en consulta

}
