package com.datacar.persistence;


import javax.persistence.*;

@Entity(name = "auto_cliente")
@Table(name = "auto_cliente")
public class AutoClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;


    //TODO add implementation

}
