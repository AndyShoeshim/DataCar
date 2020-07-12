package com.datacar.persistence;

import com.datacar.model.Test;

import javax.persistence.*;


@Entity(name = "test")
@Table(name = "test")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    @Column(nullable = false)
    String name;


    public TestEntity() {
    }

    public TestEntity(Test test) {
        this.name = test.getName();
    }
}
