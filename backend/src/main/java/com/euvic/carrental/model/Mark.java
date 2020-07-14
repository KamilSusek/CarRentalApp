package com.euvic.carrental.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "marks")
@Entity
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String markName;

    @OneToMany(mappedBy = "mark",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Model> models;

    @OneToMany(mappedBy = "mark",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Car> cars;

    public Mark() {
    }

    public Mark(String markName) {
        this.markName = markName;
    }
}
